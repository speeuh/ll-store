package com.ll.store.model.product;

import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.service.dto.product.ProductUpdateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
public class ProductUpdateModel {

    @Size(
            min = 2,
            max = 10,
            message = "Product name accepts at most 10 characters and at least 2 characters"
    )
    private String name;
    @Size( max = 200, message = "Product description accepts at most 200 characters" )
    private String description;
    private Double value;

    public ProductUpdateDto convertUpdateModelToDto(){
        return new ProductUpdateDto(name, description, value);
    }
}
