package com.example.springbootexercice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "t_rates")
public class RateEntity {

    //Atributos

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name ="BRAND_ID",nullable = false)
    private Long brand;
    @Column (name = "PRODUCT_ID",nullable = false)
    private Long product;
    @Column (name = "START_DATE",nullable = false)
    private LocalDate startDate;
    @Column (name = "END_DATE",nullable = false)
    private LocalDate endDate;
    @Column (name = "PRICE",nullable = false)
    private Integer price;
    @Column (name = "CURRENCY_CODE",nullable = false)
    private String currencyCode;

}
