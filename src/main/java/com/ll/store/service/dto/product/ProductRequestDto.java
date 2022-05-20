package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductRequestDto {

    private String productName;
    private String brandName;
    private Double productValue;
    private Date productExpiry;

    public ProductRequestDto(String productName, String brandName, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brandName = brandName;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public Product convertDtoToEntity(){
        return new Product(productName, brandName, productValue, productExpiry);
    }

}
