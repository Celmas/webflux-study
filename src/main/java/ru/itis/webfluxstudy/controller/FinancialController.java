package ru.itis.webfluxstudy.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;
import ru.itis.webfluxstudy.service.FinancialService;

@RestController
@RequestMapping("/financial")
public class FinancialController {
    private final FinancialService service;

    public FinancialController(@Qualifier("WebServiceApiFinancialService") FinancialService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<FinancialPlatformDto> getAll() {
        return service.getAll();
    }
}

