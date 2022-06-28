package com.ll.store.service.dto.brand;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandRequestDto {

    private String name;

    public BrandRequestDto(String name) {
        this.name = name;
    }

    public Brand convertBrandDtoToEntity(){
        return new Brand(name);
    }
}
