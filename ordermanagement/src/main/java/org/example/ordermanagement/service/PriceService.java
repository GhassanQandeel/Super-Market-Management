package org.example.ordermanagement.service;


import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Price getPrice(Long id) {
       Optional<Price> price = priceRepository.findById(id);
        if (price.isEmpty())
            throw new RuntimeException("Price with id "+ id +" not found");

        return price.get();

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
