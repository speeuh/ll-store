package com.ll.store.repository.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.service.dto.product.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName="id")
    private Brand brand;
    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName="id")
    private Section section;
    private Double productValue;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date productDate;
    private Date productExpiry;

    public Product(String productName, Brand brand, Section section, Double productValue, Date productExpiry) {
        this.productName = productName;
        this.brand = brand;
        this.section = section;
        this.productValue = productValue;
        this.productExpiry = productExpiry;
    }

    public Product() {
    }

    public ProductResponseDto convertEntityToResponse(){
        return new ProductResponseDto(id, productName, brand, section, productValue, productDate, productExpiry);
    }
}
