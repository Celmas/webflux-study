package ru.itis.webfluxstudy.service;

import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;

public interface FinancialService {
    Flux<FinancialPlatformDto> getAll();
}
