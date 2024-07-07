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
    @ManyToOne
    @JoinColumn (name = "brand_id", nullable = false)
    private BrandEntity brandEntity;
    @ManyToOne
    @JoinColumn (name = "product_id", nullable = false)
    private ProductEntity productEntity;
    @Column (name = "START_DATE")
    private LocalDate startDate;
    @Column (name = "END_DATE")
    private LocalDate endDate;
    @Column (name = "PRICE")
    private Integer price;

    @ManyToOne
    @JoinColumn (name = "currencyCode_id", nullable = false)
    private CurrencyCodeEntity currencyCode;

}
