package com.example.springbootexercice.controller;

import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.DTO.RatePriceDTO;
import com.example.springbootexercice.entity.RateEntity;
import com.example.springbootexercice.service.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<RateEntityDTO> createRate (@RequestBody RateEntityDTO rateEntityDTO) {

        RateEntityDTO result = rateService.createRate(rateEntityDTO);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleleRate (@PathVariable Long id){

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

}
