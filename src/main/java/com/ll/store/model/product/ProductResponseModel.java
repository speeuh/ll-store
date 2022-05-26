package com.ll.store.model.product;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductResponseModel {

    private long id;
    private String productName;
    private Brand brand;
    private Double productValue;
    private Date productDate;
    private Date productExpiry;

    public ProductResponseModel(long id, String productName, Brand brand, Double productValue, Date productDate, Date productExpiry) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.productValue = productValue;
        this.productDate = productDate;
        this.productExpiry = productExpiry;
    }

}
