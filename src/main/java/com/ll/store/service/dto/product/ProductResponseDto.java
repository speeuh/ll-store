package com.ll.store.service.dto.product;

import com.ll.store.model.product.ProductResponseModel;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.section.Section;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductResponseDto {

    private long id;
    private String productName;
    private Brand brand;
    private Section section;
    private String description;
    private Double productValue;
    private Date productDate;
    private Date productExpiry;

    public ProductResponseDto(long id, String productName, Brand brand, Section section, String description, Double productValue, Date productDate, Date productExpiry) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.section = section;
        this.description = description;
        this.productValue = productValue;
        this.productDate = productDate;
        this.productExpiry = productExpiry;
    }

    public ProductResponseModel convertResponseDtoToResponseModel(){
        return new ProductResponseModel(id, productName, brand, section, description, productValue, productDate, productExpiry);
    }

}
