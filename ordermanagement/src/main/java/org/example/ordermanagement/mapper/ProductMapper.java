package org.example.ordermanagement.mapper;

import org.example.ordermanagement.controller.dto.ProductDto;
import org.example.ordermanagement.projections.OrderItemsProjections;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ProductMapper{

    ProductDto toProductDto(OrderItemsProjections orderItemsProjections);
    List<ProductDto> toProductDtoList(List<OrderItemsProjections> orderItemsProjections);

}
