package com.ll.store.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.service.dto.product.ProductRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class ProductRequestModel {

    @NotNull @NotBlank
    private String productName;
    @NotNull @NotBlank
    private String brandName;
    @NotNull
    private Double productValue;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date productExpiry;

    public ProductRequestDto convertRequestModelToDto(){
        return new ProductRequestDto(productName, brandName, productValue, productExpiry);
    }
}