package ru.itis.webfluxstudy.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Qualifier("CombineService")
public class CombineServiceImpl implements FinancialService {
    private List<FinancialService> services;
    @Override
    public Flux<FinancialPlatformDto> getAll() {
        List<Flux<FinancialPlatformDto>> fluxList = services.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(fluxList);
    }

    private Flux<FinancialPlatformDto> getAll(FinancialService service) {
        return service.getAll().subscribeOn(Schedulers.elastic());
    }
}
