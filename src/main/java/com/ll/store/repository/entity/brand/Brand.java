package com.ll.store.repository.entity.brand;

import com.ll.store.service.dto.brand.BrandResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name", unique = true)
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }

    public BrandResponseDto convertBrandEntityToResponseDto(){
        return new BrandResponseDto(id, name);
    }
}
