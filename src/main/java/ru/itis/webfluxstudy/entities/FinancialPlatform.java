package ru.itis.webfluxstudy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialPlatform {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String category;
    private String facts;
    private boolean centralized;
    private String websiteUrl;
}
