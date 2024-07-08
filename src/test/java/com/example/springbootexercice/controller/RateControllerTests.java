package com.example.springbootexercice.controller;

import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.DTO.RateEntityNewDTO;
import com.example.springbootexercice.DTO.RatePriceDTO;
import com.example.springbootexercice.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RateController.class)
public class RateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RateService rateService;

    @Test
    public void testGetById() throws Exception {
        RateEntityDTO mockRateDTO = new RateEntityDTO();

        when(rateService.getById(1L)).thenReturn(mockRateDTO);

        mockMvc.perform(get("/rates/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateRate() throws Exception {
        RateEntityNewDTO mockRateEntityNewDTO = new RateEntityNewDTO();

        when(rateService.createRate(any(RateEntityNewDTO.class))).thenReturn(mockRateEntityNewDTO);

        mockMvc.perform(post("/rates/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(mockRateEntityNewDTO)))
                        .andExpect(status().isOk());
    }
    @Test
    public void testDeleteRate() throws Exception {
        Long idToDelete = 1L;
        when(rateService.getById(idToDelete)).thenReturn(new RateEntityDTO());

        mockMvc.perform(delete("/rates/{id}", idToDelete))
                .andExpect(status().isNoContent());

        verify(rateService, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testUpdatePrice() throws Exception {
        Long idToUpdate = 1L;
        Integer price = 3000;
        RatePriceDTO mockRatePriceDTO = new RatePriceDTO();
        mockRatePriceDTO.setPrice(price);
        String response = "Updated successfully";
        when(rateService.updatePrice(idToUpdate,price)).thenReturn(response);

        mockMvc.perform(patch("/rates/{id}", idToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(mockRatePriceDTO)))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Updated successfully"));
    }
    @Test
    public void testGetRateByCriteria() throws Exception {
        Long brandId = 1L;
        Long productId = 2L;
        LocalDate date = LocalDate.now();

        RateEntityDTO mockRateDTO = new RateEntityDTO();

        when(rateService.getRateByCriteria(brandId, productId, date)).thenReturn(mockRateDTO);

        mockMvc.perform(get("/rates/search")
                        .param("brandId", String.valueOf(brandId))
                        .param("productId", String.valueOf(productId))
                        .param("date", date.toString()))
                .andExpect(status().isOk());
    }
}
