package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDto {

    private String name;
    private String description;
    private Double value;

    public ProductUpdateDto(String name, String description, Double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

}
