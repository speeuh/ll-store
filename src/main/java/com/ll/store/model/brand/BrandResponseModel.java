package com.ll.store.model.brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandResponseModel {

    private String id;
    private String name;

    public BrandResponseModel(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
