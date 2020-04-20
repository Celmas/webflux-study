package ru.itis.webfluxstudy.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FinancialPlatformApiRecord {
    private String name;
    private String category;
    private String facts;
    private boolean centralized;
    @JsonProperty("website_url")
    private String websiteUrl;
}
