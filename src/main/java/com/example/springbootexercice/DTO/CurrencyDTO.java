package com.example.springbootexercice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDTO {

    private Long id;
    private String symbol;
    private String code;
    private int decimals;
}
