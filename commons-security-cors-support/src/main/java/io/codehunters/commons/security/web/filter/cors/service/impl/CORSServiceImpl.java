package io.codehunters.commons.security.web.filter.cors.service.impl;

import io.codehunters.commons.repository.cors.support.CORSRepositiry;
import io.codehunters.commons.repository.cors.support.domain.Cors;
import io.codehunters.commons.security.web.filter.cors.service.CORSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CORSServiceImpl implements CORSService {

    private CORSRepositiry corsRepositiry;

    public CORSServiceImpl(CORSRepositiry corsRepositiry) {
        this.corsRepositiry = corsRepositiry;
    }

    @Override
    public List<String> fetchAll() {
        Optional<List<Cors>> result = corsRepositiry.findAllByEnabledEquals(Boolean.TRUE);
        if(result.isPresent()) {
            return result.get()
                    .stream()
                    .map(cors -> cors.getUrls())
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
