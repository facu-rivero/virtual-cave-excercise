package com.example.springbootexercice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateEntityNewDTO {
    private Long id;
    private Long brand;
    private Long product;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
    private String currencyCode;

}
