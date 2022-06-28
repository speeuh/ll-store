package com.ll.store.service.dto.brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandUpdateDto {

    private String name;

    public BrandUpdateDto(String name) {
        this.name = name;
    }
}
