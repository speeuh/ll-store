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
    private String description;
    private Double productValue;
    private Date productExpiry;

    public ProductRequestDto(String productName, Brand brand, Section section, String description, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brand = brand;
        this.section = section;
        this.description = description;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public Product convertDtoToEntity(){
        return new Product(productName, brand, section, description, productValue, productExpiry);
    }

}
