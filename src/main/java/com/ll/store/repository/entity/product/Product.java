package com.ll.store.repository.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.file.File;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.service.dto.product.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName="id")
    private Brand brand;
    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName="id")
    private Section section;
    private String description;
    private Double value;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private Date expiry;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "file_id", referencedColumnName="id")
    private File file;

    public Product(String name, Brand brand, Section section, String description, Double value, Date expiry) {
        this.name = name;
        this.brand = brand;
        this.section = section;
        this.description = description;
        this.value = value;
        this.expiry = expiry;
    }

    public Product() {
    }

    public ProductResponseDto convertEntityToResponse(){
        return new ProductResponseDto(id, name, brand, section, description, value, date, expiry, file);
    }
}
