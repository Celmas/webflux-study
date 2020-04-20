package ru.itis.webfluxstudy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialPlatformDto {
    private String name;
    private String category;
    private String facts;
    private boolean centralized;
    private String websiteUrl;
    private String source;
}
