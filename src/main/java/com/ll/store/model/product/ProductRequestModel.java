package com.ll.store.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.service.dto.product.ProductRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class ProductRequestModel {

    @NotNull @NotBlank
    private String name;
    @NotNull
    private Brand brand;
    @NotNull
    private Section section;
    @NotNull @NotBlank
    private String description;
    private Double value;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiry;

    public ProductRequestDto convertRequestModelToDto(){
        return new ProductRequestDto(name, brand, section, description, value, expiry);
    }
}
