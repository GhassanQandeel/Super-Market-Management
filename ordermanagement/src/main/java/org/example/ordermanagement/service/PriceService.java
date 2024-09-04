package org.example.ordermanagement.service;

import lombok.Setter;
import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;


    public List<Price> getPrice() {
        return priceRepository.findAll();
    }
    public void setPrice(Price price) {
        priceRepository.save(price);
    }

}
