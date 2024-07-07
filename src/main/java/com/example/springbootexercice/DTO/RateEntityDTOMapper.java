package com.example.springbootexercice.DTO;

import com.example.springbootexercice.entity.RateEntity;

public class RateEntityDTOMapper {

    public static RateEntityDTO toDto(RateEntity rateEntity) {

        return new RateEntityDTO(
                rateEntity.getId(),
                rateEntity.getBrandEntity(),
                rateEntity.getProductEntity(),
                rateEntity.getStartDate(),
                rateEntity.getEndDate(),
                rateEntity.getPrice(),
                rateEntity.getCurrencyCode()
        );
    }
}