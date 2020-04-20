package ru.itis.webfluxstudy.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.client.Client;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;

@Service
@AllArgsConstructor
@Qualifier("WebServiceApiFinancialService")
public class WebServiceApiFinancialServiceImpl implements FinancialService {
    private Client client;
    @Override
    public Flux<FinancialPlatformDto> getAll() {
        return client.getAll();
    }
}
