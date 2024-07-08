package com.example.springbootexercice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration("mockCurrencyConfiguration")
public class MockCurrencyConfiguration {

    @Autowired
    @Qualifier ("mockCurrencyConfigurationProperties")
    private MockCurrencyConfigurationProperties mockCurrencyConfigurationProperties;

    @Bean
    public WebClient webClient () {

        return WebClient.builder()
                .baseUrl(mockCurrencyConfigurationProperties.getBaseURL())
                .build();
    }
}
