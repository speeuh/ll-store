package com.ll.store.service.dto.product;

import com.ll.store.model.product.ProductResponseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductResponseDto {

    private long id;
    private String productName;
    private String brandName;
    private Double productValue;
    private Date productExpiry;

    public ProductResponseDto(String productName, String brandName, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brandName = brandName;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public ProductResponseModel convertResponseDtoToResponseModel(){
        return new ProductResponseModel(id, productName, brandName, productValue, productExpiry);
    }

}
