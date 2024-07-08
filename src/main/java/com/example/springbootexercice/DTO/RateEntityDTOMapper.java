package com.example.springbootexercice.DTO;

import com.example.springbootexercice.entity.RateEntity;

public class RateEntityDTOMapper {

    public static RateEntityDTO toDto(RateEntity rateEntity, String symbol, double decimalPrice) {

        return new RateEntityDTO(
                rateEntity.getId(),
                rateEntity.getBrand(),
                rateEntity.getProduct(),
                rateEntity.getStartDate(),
                rateEntity.getEndDate(),
                decimalPrice,
                rateEntity.getCurrencyCode(),
                symbol
        );
    }

}