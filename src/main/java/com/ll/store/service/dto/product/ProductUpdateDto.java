package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDto {

    private String productName;
    private Double productValue;

    public ProductUpdateDto(String productName, Double productValue) {
        this.productName = productName;
        this.productValue = productValue;
    }

}
