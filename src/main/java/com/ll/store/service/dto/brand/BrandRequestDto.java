package com.ll.store.service.dto.brand;

import com.ll.store.repository.entity.brand.Brand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandRequestDto {

    private String brandName;

    public BrandRequestDto(String brandName) {
        this.brandName = brandName;
    }

    public Brand convertBrandDtoToEntity(){
        return new Brand(brandName);
    }
}
