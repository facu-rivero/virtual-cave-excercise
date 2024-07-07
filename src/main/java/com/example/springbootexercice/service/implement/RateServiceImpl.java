package com.example.springbootexercice.service.implement;

import com.example.springbootexercice.DTO.RateEntityDTO;
import com.example.springbootexercice.DTO.RateEntityDTOMapper;
import com.example.springbootexercice.entity.RateEntity;
import com.example.springbootexercice.repository.RateRepository;
import com.example.springbootexercice.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public RateEntityDTO getById(Long id) {

        Optional<RateEntity> rateEntityOptional = rateRepository.findById(id);
        if (rateEntityOptional.isPresent()) {
            return RateEntityDTOMapper.toDto(rateEntityOptional.get());
        }
        return null;
    }

    @Override
    public RateEntityDTO createRate(RateEntityDTO rateEntityDTO) {

        RateEntity rateEntity = new RateEntity();

        rateEntity.setBrandEntity(rateEntityDTO.getBrand());
        rateEntity.setProductEntity(rateEntityDTO.getProduct());
        rateEntity.setStartDate(rateEntityDTO.getStartDate());
        rateEntity.setEndDate(rateEntityDTO.getEndDate());
        rateEntity.setPrice(rateEntityDTO.getPrice());
        rateEntity.setCurrencyCode(rateEntityDTO.getCurrencyCode());

        RateEntity result = rateRepository.save(rateEntity);
        return RateEntityDTOMapper.toDto(result);

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
            RateEntityDTOMapper.toDto(result);
            return "Update Successful";
        }
        return "Error Update";
    } 
}
