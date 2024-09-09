package org.example.ordermanagement.service;

import lombok.Setter;
import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;


    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }
    public void createPrice(Price price) {
        priceRepository.save(price);
    }

    public List<Long> getPriceIds() {
        List<Price> prices = priceRepository.findAll();
        List<Long> ids = new ArrayList<>();
        for (Price price : prices) {
            ids.add(price.getId());
        }
        return ids;
    }

}
