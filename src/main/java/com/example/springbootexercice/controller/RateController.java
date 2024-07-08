package com.example.springbootexercice.controller;

import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.DTO.RateEntityNewDTO;
import com.example.springbootexercice.DTO.RatePriceDTO;
import com.example.springbootexercice.service.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("rates")
public class RateController {

    @Autowired
    private RateService rateService;

    private final Logger log = LoggerFactory.getLogger(RateController.class);

    @GetMapping("/{id}")
    public ResponseEntity<RateEntityDTO> getById (@PathVariable Long id) {

        Optional<RateEntityDTO> rate = Optional.ofNullable(rateService.getById(id));

        if(rate.isPresent()) {
            return ResponseEntity.ok(rate.get());
        } else

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<RateEntityNewDTO> createRate (@RequestBody RateEntityNewDTO rateEntityNewDTO) {

        RateEntityNewDTO rate = rateService.createRate(rateEntityNewDTO);

        return ResponseEntity.ok(rate);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteRate (@PathVariable Long id){

        if(rateService.getById(id) == null) {
            log.warn("La tarifa que desea eliminar no existe");
            return ResponseEntity.notFound().build();
        }
        rateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<String> updatePrice (@PathVariable Long id, @RequestBody RatePriceDTO price){

        String result = rateService.updatePrice(id, price.getPrice());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<RateEntityDTO> getRateByCriteria(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {

        Optional<RateEntityDTO> rate = Optional.ofNullable(rateService.getRateByCriteria(brandId, productId, date));
        if (rate.isPresent()) {
            RateEntityDTO rateDTO = rate.get();
            return ResponseEntity.ok(rateDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
