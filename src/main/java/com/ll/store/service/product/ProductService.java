package com.ll.store.service.product;

import com.ll.store.config.validation.exceptions.BrandNotFoundException;
import com.ll.store.config.validation.exceptions.ProductNotFoundException;
import com.ll.store.repository.brand.BrandRepository;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.service.dto.product.ProductRequestDto;
import com.ll.store.service.dto.product.ProductResponseDto;
import com.ll.store.repository.entity.product.Product;
import com.ll.store.repository.product.ProductRepository;
import com.ll.store.service.dto.product.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto){

        Brand brand = brandRepository.findById(productRequestDto.getBrand().getId()).orElseThrow(() -> new BrandNotFoundException("Not found brand with id: " + productRequestDto.getBrand().getId()));
        productRequestDto.getBrand().setBrandName(brand.getBrandName());

        Date date = new Date();

        Product product = productRequestDto.convertDtoToEntity();
        product.setProductDate(date);
        Product productResponse = productRepository.save(product);

        return productResponse.convertEntityToResponse();
    }

    public Page<ProductResponseDto> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable).map(Product::convertEntityToResponse);
    }

    public ProductResponseDto getById(long id){

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Not found product with id " + id));
        return product.convertEntityToResponse();
    }

    public void deleteById(long id){
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ProductNotFoundException("Not found product with id " + id);
        }
    }

    public ProductResponseDto updateById(ProductUpdateDto productUpdateDto, long id){

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Not found product with id " + id));

        if(productUpdateDto.getProductName() != null){
            product.setProductName(productUpdateDto.getProductName());
        }

        if(productUpdateDto.getProductValue() != null){
            product.setProductValue(productUpdateDto.getProductValue());
        }

        Product productResponse = productRepository.save(product);
        return productResponse.convertEntityToResponse();
    }

}
