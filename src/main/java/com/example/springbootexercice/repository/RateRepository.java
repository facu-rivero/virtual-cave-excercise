package com.example.springbootexercice.repository;

import com.example.springbootexercice.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository <RateEntity, Long> {
    @Query("SELECT r FROM RateEntity r WHERE r.product = :productId AND r.brand = :brandId AND :date BETWEEN r.startDate AND r.endDate")
    Optional<RateEntity> findApplicableRate(LocalDate date, Long productId, Long brandId);
}
