package com.ll.store.repository.entity.brand;

import com.ll.store.service.dto.brand.BrandResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "brand_name", unique = true)
    private String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand() {
    }

    public BrandResponseDto convertBrandEntityToResponseDto(){
        return new BrandResponseDto(id, brandName);
    }
}
