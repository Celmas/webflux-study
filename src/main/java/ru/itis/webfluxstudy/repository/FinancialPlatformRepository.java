package ru.itis.webfluxstudy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.webfluxstudy.entities.FinancialPlatform;

public interface FinancialPlatformRepository extends JpaRepository<FinancialPlatform, Long> {
}
