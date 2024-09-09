package org.example.ordermanagement.mapper;


import org.example.ordermanagement.controller.dto.product.ProductDto;
import org.example.ordermanagement.controller.requestdto.product.ProductRequestDto;
import org.example.ordermanagement.model.Price;
import org.example.ordermanagement.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class ProductMapper {

    public abstract ProductDto toProductDto(Product product);

    public List<ProductDto> toProductDtoList(List<Product> products){
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(toProductDto(product));
        }
        return productDtos;
    }

    public Product toProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setPrice(new Price(productRequestDto.getPriceId(), 0, 0));
        return product;
    }
}
