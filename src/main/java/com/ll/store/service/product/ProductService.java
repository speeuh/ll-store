package com.ll.store.service.product;

import com.ll.store.service.dto.product.ProductRequestDto;
import com.ll.store.service.dto.product.ProductResponseDto;
import com.ll.store.repository.entity.product.Product;
import com.ll.store.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto){

        Date date = new Date();

        Product product = productRequestDto.convertDtoToEntity();
        product.setProductDate(date);
        Product productResponse = productRepository.save(product);

        return productResponse.convertEntityToResponse();
    }

}
