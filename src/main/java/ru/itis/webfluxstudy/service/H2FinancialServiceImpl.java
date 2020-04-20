package ru.itis.webfluxstudy.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;
import ru.itis.webfluxstudy.repository.FinancialPlatformRepository;

@Service
@Qualifier("H2FinancialService")
@AllArgsConstructor
public class H2FinancialServiceImpl implements FinancialService {
    private FinancialPlatformRepository repository;

    @Override
    public Flux<FinancialPlatformDto> getAll() {
        return Flux.fromStream((repository.findAll().stream().map(record -> FinancialPlatformDto.builder()
                .name(record.getName())
                .category(record.getCategory())
                .centralized(record.isCentralized())
                .facts(record.getFacts())
                .source("H2")
                .websiteUrl(record.getWebsiteUrl())
                .build())));
    }
}
