package com.ll.store.service.dto.product;

import com.ll.store.model.product.ProductResponseModel;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.file.File;
import com.ll.store.repository.entity.section.Section;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductResponseDto {

    private String id;
    private String name;
    private Brand brand;
    private Section section;
    private String description;
    private Double value;
    private Date date;
    private Date expiry;
    private File file;

    public ProductResponseDto(String id, String name, Brand brand, Section section, String description, Double value, Date date, Date expiry, File file) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.section = section;
        this.description = description;
        this.value = value;
        this.date = date;
        this.expiry = expiry;
        this.file = file;
    }

    public ProductResponseModel convertResponseDtoToResponseModel(){
        return new ProductResponseModel(id, name, brand, section, description, value, date, expiry, file);
    }

}
