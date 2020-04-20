package ru.itis.webfluxstudy.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.webfluxstudy.entities.FinancialPlatformDto;
import ru.itis.webfluxstudy.entities.FinancialPlatformApiRecord;

import java.util.Arrays;

@Component
public class FinancialPlatformClientImpl implements Client {
    private WebClient client;

    public FinancialPlatformClientImpl(@Value("${financial.platform.api.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .baseUrl(url)
                .build();
    }
    @Override
    public Flux<FinancialPlatformDto> getAll() {
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(FinancialPlatformApiRecord[].class)) // преобразуем данные со стороннего сервреа в Publisher
                .flatMapIterable(Arrays::asList)
                .map(record ->
                        FinancialPlatformDto.builder()
                                .name(record.getName())
                                .category(record.getCategory())
                                .centralized(record.isCentralized())
                                .facts(record.getFacts())
                                .source("WebService")
                                .websiteUrl(record.getWebsiteUrl())
                                .build());
    }
}
