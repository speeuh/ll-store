package com.ll.store.model.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductResponseModel {

    private long id;
    private String productName;
    private String brandName;
    private Double productValue;
    private Date productExpiry;

    public ProductResponseModel(long id, String productName, String brandName, Double productValue, Date productExpiry) {
        this.id = id;
        this.productName = productName;
        this.brandName = brandName;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

}
