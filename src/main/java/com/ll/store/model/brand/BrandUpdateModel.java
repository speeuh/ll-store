package com.ll.store.model.brand;

import com.ll.store.service.dto.brand.BrandUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandUpdateModel {

    private String name;

    public BrandUpdateDto convertUpdateModelToDto() {
        return new BrandUpdateDto(name);
    }
}
