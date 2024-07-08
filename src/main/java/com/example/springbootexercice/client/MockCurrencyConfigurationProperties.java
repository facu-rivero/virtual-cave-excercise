package com.example.springbootexercice.client;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("mockCurrencyConfigurationProperties")
public class MockCurrencyConfigurationProperties {

    private String baseURL;
    private Integer connectionTimeOut;
    private Long responseTimeOut = 342523L;
}
