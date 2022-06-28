package com.ll.store.service.dto.brand;

import com.ll.store.model.brand.BrandResponseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandResponseDto {

    private String id;
    private String name;

    public BrandResponseDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandResponseModel convertBrandResponseDtoToModel(){
        return new BrandResponseModel(id, name);
    }
}
