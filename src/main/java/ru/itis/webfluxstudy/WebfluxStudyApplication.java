package ru.itis.webfluxstudy;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itis.webfluxstudy.entities.FinancialPlatform;
import ru.itis.webfluxstudy.repository.FinancialPlatformRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebfluxStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebfluxStudyApplication.class, args);

        FinancialPlatformRepository repository = applicationContext.getBean(FinancialPlatformRepository.class);

        List<FinancialPlatform> financialPlatforms = new ArrayList<>();
        for (int i = 0; i < 1500; i++) {
            FinancialPlatform financialPlatform = FinancialPlatform.builder()
                    .name(RandomStringUtils.randomAlphabetic(10))
                    .websiteUrl(RandomStringUtils.randomAlphabetic(15))
                    .facts(RandomStringUtils.randomAlphabetic(20))
                    .category(RandomStringUtils.randomAlphabetic(10))
                    .centralized(Math.random() < 0.5).build();
            financialPlatforms.add(financialPlatform);
        }
        repository.saveAll(financialPlatforms);
    }

}
