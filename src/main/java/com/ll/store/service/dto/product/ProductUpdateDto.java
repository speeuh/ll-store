package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDto {

    private String productName;
    private String description;
    private Double productValue;

    public ProductUpdateDto(String productName, String description, Double productValue) {
        this.productName = productName;
        this.productValue = productValue;
    }

}
