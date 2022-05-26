package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductRequestDto {

    private String productName;
    private Brand brand;
    private Double productValue;
    private Date productExpiry;

    public ProductRequestDto(String productName, Brand brand, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brand = brand;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public Product convertDtoToEntity(){
        return new Product(productName, brand, productValue, productExpiry);
    }

}
