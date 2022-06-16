package com.ll.store.service.dto.product;

import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.product.Product;
import com.ll.store.repository.entity.section.Section;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductRequestDto {

    private String productName;
    private Brand brand;
    private Section section;
    private Double productValue;
    private Date productExpiry;

    public ProductRequestDto(String productName, Brand brand, Section section, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brand = brand;
        this.section = section;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public Product convertDtoToEntity(){
        return new Product(productName, brand, section, productValue, productExpiry);
    }

}
