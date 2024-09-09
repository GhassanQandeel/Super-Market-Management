package org.example.ordermanagement.controller;

import org.example.ordermanagement.controller.dto.price.PriceDto;
import org.example.ordermanagement.controller.requestdto.price.PriceRequestDto;
import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.price.PriceRequestNullException;
import org.example.ordermanagement.mapper.PriceMapper;
import org.example.ordermanagement.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;
    @Autowired
    private PriceMapper priceMapper;

    @GetMapping
    public List<PriceDto> getAllPrices() {
        return priceMapper.toDto(priceService.getAllPrices());
    }

    @PostMapping
    public void createPrice(@RequestBody PriceRequestDto priceRequestDto) {
        if(Objects.isNull(priceRequestDto)) {
            throw new PriceRequestNullException("The request is null", Code.PRICE_REQUEST_NULL);
        }
        priceService.createPrice(priceMapper.toEntity(priceRequestDto));
    }

}
