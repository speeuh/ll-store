package com.ll.store.service.dto.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDto {

    private String productName;
    private String brandName;
    private Double productValue;

    public ProductUpdateDto(String productName, String brandName, Double productValue) {
        this.productName = productName;
        this.brandName = brandName;
        this.productValue = productValue;
    }

}
