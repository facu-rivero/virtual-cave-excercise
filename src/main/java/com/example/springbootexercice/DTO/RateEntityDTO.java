package com.example.springbootexercice.DTO;

import com.example.springbootexercice.entity.BrandEntity;
import com.example.springbootexercice.entity.CurrencyCodeEntity;
import com.example.springbootexercice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateEntityDTO {
    private Long id;
    private BrandEntity brand;
    private ProductEntity product;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
    private CurrencyCodeEntity currencyCode;
}