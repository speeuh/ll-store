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

    private String name;
    private Brand brand;
    private Section section;
    private String description;
    private Double value;
    private Date expiry;

    public ProductRequestDto(String name, Brand brand, Section section, String description, Double value, Date expiry) {
        this.name = name;
        this.brand = brand;
        this.section = section;
        this.description = description;
        this.value = value;
        this.expiry = expiry;
    }

    public Product convertDtoToEntity(){
        return new Product(name, brand, section, description, value, expiry);
    }

}
