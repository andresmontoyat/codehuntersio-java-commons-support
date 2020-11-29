package io.codehunters.commons.security.web.filter.cors.service.impl;

import io.codehunters.commons.jpa.repository.cors.CorsJpaRepository;
import io.codehunters.commons.jpa.repository.cors.domain.CorsEntity;
import io.codehunters.commons.security.web.filter.cors.service.CorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CorsServiceImpl implements CorsService {

    private CorsJpaRepository corsJpaRepository;

    public CorsServiceImpl(CorsJpaRepository corsJpaRepository) {
        this.corsJpaRepository = corsJpaRepository;
    }

    @Override
    public List<String> fetchAll() {
        List<CorsEntity> result = corsJpaRepository.findAll();
        if(result != null) {
            return result.stream()
                    .map(cors -> cors.getUrls())
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
