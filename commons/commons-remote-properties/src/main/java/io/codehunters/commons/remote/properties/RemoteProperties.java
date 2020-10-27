package io.codehunters.commons.remote.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("unchecked")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoteProperties extends PropertySourcesPlaceholderConfigurer {

    private RequestEntity requestEntity;

    private String propertyKey;

    private String propertyValue;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final Map properties = new Properties();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.exchange(requestEntity, List.class);
        if(HttpStatus.OK.equals(response.getStatusCode())) {
            response.getBody().stream().forEach(o -> {
                String key = (String) ((Map) o).get(propertyKey);
                String value = (String) ((Map) o).get(propertyValue);
                properties.put(key, value);
            });
        }

        setProperties((Properties) properties);
        PropertySource propertySource = new MapPropertySource("REMOTE_PROPERTIES", properties);
        PropertySources propertySources = new MutablePropertySources();
        ((MutablePropertySources) propertySources).addLast(propertySource);
        setPropertySources(propertySources);

        super.postProcessBeanFactory(beanFactory);
    }

}
