package org.example.ordermanagement.controller;

import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prices")
public class PriceController {

    @Autowired
    private PriceService priceService;


    @GetMapping
    // Where is dtos ?
    public List<Price> getPrice() {
        return  priceService.getPrice();
    }

    @PostMapping
    // Where is dtos ?
    public void setPrice(@RequestBody Price price) {
        priceService.setPrice(price);
    }

}
