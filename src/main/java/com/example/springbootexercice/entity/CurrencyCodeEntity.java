package com.example.springbootexercice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_currency")
public class CurrencyCodeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "currencyCode")
    @JsonIgnore
    private List<RateEntity> rateEntityList;

}
