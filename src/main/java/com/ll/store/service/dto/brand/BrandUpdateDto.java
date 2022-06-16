package com.ll.store.service.dto.brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandUpdateDto {

    private String brandName;

    public BrandUpdateDto(String brandName) {
        this.brandName = brandName;
    }
}
