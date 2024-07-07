package com.example.springbootexercice.repository;

import com.example.springbootexercice.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository <RateEntity, Long> {
}
