package com.example.springbootexercice.service;


import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.entity.RateEntity;

public interface RateService {

    RateEntityDTO getById(Long id);

    RateEntityDTO createRate(RateEntityDTO rateEntityDTO);

    void deleteById(Long id);

    String updatePrice(Long id, Integer price);
}
