package com.example.springbootexercice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateEntityDTO {
    private Long id;
    private Long brand;
    private Long product;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String currencyCode;
    private String symbol;
}