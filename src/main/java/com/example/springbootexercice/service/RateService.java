package com.example.springbootexercice.service;

import com.example.springbootexercice.DTO.CurrencyDTO;
import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.DTO.RateEntityNewDTO;

import java.time.LocalDate;

import java.util.List;

public interface RateService {

    RateEntityDTO getById(Long id);

    RateEntityNewDTO createRate(RateEntityNewDTO rateEntityNewDTO);

    void deleteById(Long id);

    String updatePrice(Long id, Integer price);

    CurrencyDTO getCurrencyByCode(String currencyCode);

    RateEntityDTO getRateByCriteria(Long brandId, Long productId, LocalDate date);
}
