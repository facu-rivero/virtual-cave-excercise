package com.example.springbootexercice.DTO;

import com.example.springbootexercice.entity.RateEntity;

public class RatePriceDTOMapper {
    public static RatePriceDTO toDto(RateEntity rateEntity) {

        return new RatePriceDTO(
                rateEntity.getPrice()
        );
    }
}
