package com.ll.store.repository.entity.file;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.repository.entity.product.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    private String fileName;

    private byte[] data;

    private String type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id", referencedColumnName="id")
    private Product product;

    public File() {
    }

    public File(String fileName, byte[] data, String type, Product product) {
        this.fileName = fileName;
        this.data = data;
        this.type = type;
        this.product = product;
    }

    public static class FileBuilder{

        private String fileName;
        private byte[] data;
        private String type;
        private Product product;

        private FileBuilder(byte[] data) {
            this.data = data;
        }

        public static FileBuilder newBuilder(byte[] data) {
            return new FileBuilder(data);
        }

        public FileBuilder withFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public FileBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileBuilder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public File build() {
            return new File(fileName, data, type, product);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
