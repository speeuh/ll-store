package com.ll.store.model.brand;

import com.ll.store.service.dto.brand.BrandRequestDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandRequestModel {

    private String name;

    public BrandRequestDto convertBrandRequestModelToDto(){
        return new BrandRequestDto(name);
    }
}
