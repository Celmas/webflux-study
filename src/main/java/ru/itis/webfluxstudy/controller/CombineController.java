package ru.itis.webfluxstudy.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;
import ru.itis.webfluxstudy.service.FinancialService;

@RestController
@RequestMapping("/combine")
public class CombineController {
    private final FinancialService service;

    public CombineController(@Qualifier("CombineService") FinancialService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<FinancialPlatformDto> getAll() {
        return service.getAll();
    }
}
