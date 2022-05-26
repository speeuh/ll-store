package com.ll.store.service.dto.brand;

import com.ll.store.model.brand.BrandResponseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandResponseDto {

    private long id;
    private String brandName;

    public BrandResponseDto(long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public BrandResponseModel convertBrandResponseDtoToModel(){
        return new BrandResponseModel(id, brandName);
    }
}
