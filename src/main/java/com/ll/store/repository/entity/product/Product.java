package com.ll.store.repository.entity.product;

import com.ll.store.service.dto.product.ProductResponseDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    private String brandName;
    private Double productValue;
    private Date productExpiry;

    public Product(String productName, String brandName, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brandName = brandName;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public ProductResponseDto convertEntityToResponse(){
        return new ProductResponseDto(productName, brandName, productValue, productExpiry);
    }
}
