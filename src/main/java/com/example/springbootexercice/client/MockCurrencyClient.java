package com.example.springbootexercice.client;

import com.example.springbootexercice.DTO.CurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MockCurrencyClient {

    @Autowired
    private WebClient webClient;

    public Mono<List<CurrencyDTO>> getCurrency(){

        return webClient.get()
                .uri("https://668ad3752c68eaf3211df544.mockapi.io/v1/currencies/Currency")
                .retrieve()
                .bodyToFlux(CurrencyDTO.class)
                .collectList();
    }

    public Mono<CurrencyDTO> getCurrencyByCode(String currencyCode){

        return webClient.get()
                .uri("https://668ad3752c68eaf3211df544.mockapi.io/v1/currencies/Currency?code=" + currencyCode)
                .retrieve()
                .bodyToFlux(CurrencyDTO.class)
                .next();
    }

}
