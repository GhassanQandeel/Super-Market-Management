package org.example.ordermanagement.mapper;

import org.example.ordermanagement.controller.dto.price.PriceDto;
import org.example.ordermanagement.controller.requestdto.price.PriceRequestDto;
import org.example.ordermanagement.model.Price;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
@Component
public interface PriceMapper {
    PriceDto toDto(Price price);
    Price toEntity(PriceRequestDto priceRequestDto);
    List<PriceDto> toDto(List<Price> prices);


}
