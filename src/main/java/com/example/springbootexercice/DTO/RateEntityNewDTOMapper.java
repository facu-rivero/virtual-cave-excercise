package com.example.springbootexercice.DTO;

import com.example.springbootexercice.entity.RateEntity;

public class RateEntityNewDTOMapper {

    public static RateEntityNewDTO toDto(RateEntity rateEntity) {

        return new RateEntityNewDTO(
                rateEntity.getId(),
                rateEntity.getBrand(),
                rateEntity.getProduct(),
                rateEntity.getStartDate(),
                rateEntity.getEndDate(),
                rateEntity.getPrice(),
                rateEntity.getCurrencyCode()
        );
    }
}