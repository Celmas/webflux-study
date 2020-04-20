package ru.itis.webfluxstudy.client;

import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;

public interface Client {
    Flux<FinancialPlatformDto> getAll();
}
