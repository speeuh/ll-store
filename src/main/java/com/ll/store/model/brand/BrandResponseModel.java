package com.ll.store.model.brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandResponseModel {

    private long id;
    private String brandName;

    public BrandResponseModel(long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }
}
