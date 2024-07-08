package com.example.springbootexercice.service.implement;

import com.example.springbootexercice.DTO.*;
import com.example.springbootexercice.client.MockCurrencyClient;
import com.example.springbootexercice.entity.RateEntity;
import com.example.springbootexercice.repository.RateRepository;
import com.example.springbootexercice.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private MockCurrencyClient mockCurrencyClient;

    @Override
    public RateEntityDTO getById(Long id) {

        Optional<RateEntity> rateEntityOptional = rateRepository.findById(id);
        if (rateEntityOptional.isPresent()) {
            RateEntity rateEntity = rateEntityOptional.get();
            return formatRateEntity(rateEntity);
        }
        return null;
    }

    @Override
    public RateEntityNewDTO createRate(RateEntityNewDTO rateEntityNewDTO) {

        RateEntity rateEntity = new RateEntity();

        rateEntity.setBrand(rateEntityNewDTO.getBrand());
        rateEntity.setProduct(rateEntityNewDTO.getProduct());
        rateEntity.setStartDate(rateEntityNewDTO.getStartDate());
        rateEntity.setEndDate(rateEntityNewDTO.getEndDate());
        rateEntity.setPrice(rateEntityNewDTO.getPrice());
        rateEntity.setCurrencyCode(rateEntityNewDTO.getCurrencyCode());

        RateEntity result = rateRepository.save(rateEntity);
        return RateEntityNewDTOMapper.toDto(result);

    }

    @Override
    public void deleteById(Long id) {
        rateRepository.deleteById(id);
    }

    @Override
    public String updatePrice(Long id, Integer price)  {

        Optional<RateEntity> rateEntityOptional = rateRepository.findById(id);
        if (rateEntityOptional.isPresent()) {
            RateEntity rateEntity = rateEntityOptional.get();
            rateEntity.setPrice(price);
            RateEntity result = rateRepository.save(rateEntity);
            RatePriceDTOMapper.toDto(result);
            return "Update Successful";
        }
        return "Error Update";
    }
    @Override
    public RateEntityDTO getRateByCriteria(Long brandId, Long productId, LocalDate date) {
        Optional<RateEntity> rateEntityOptional = rateRepository.findApplicableRate(date, productId, brandId);
        if (rateEntityOptional.isPresent()) {
            RateEntity rateEntity = rateEntityOptional.get();
            return formatRateEntity(rateEntity);
        }
        return null;
    }

    private RateEntityDTO formatRateEntity(RateEntity rateEntity) {
        CurrencyDTO currency = getCurrencyByCode(rateEntity.getCurrencyCode());
        String symbol = currency.getSymbol();
        int decimals = currency.getDecimals();
        double formatPrice = rateEntity.getPrice() / Math.pow(10, decimals);
        return RateEntityDTOMapper.toDto(rateEntity, symbol, formatPrice);
    }

    public CurrencyDTO getCurrencyByCode(String currencyCode) {
        return mockCurrencyClient.getCurrencyByCode(currencyCode).block();
    }

}
