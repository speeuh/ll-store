package com.ll.store.service.product;

import com.ll.store.config.validation.exceptions.BrandNotFoundException;
import com.ll.store.config.validation.exceptions.ProductNotFoundException;
import com.ll.store.config.validation.exceptions.SectionNotFoundException;
import com.ll.store.repository.brand.BrandRepository;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.repository.section.SectionRepository;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto){

        Brand brand = brandRepository.findById(productRequestDto.getBrand().getId()).orElseThrow(() -> new BrandNotFoundException("Not found brand with id: " + productRequestDto.getBrand().getId()));
        productRequestDto.getBrand().setName(brand.getName());

        Section section = sectionRepository.findById(productRequestDto.getSection().getId()).orElseThrow(() -> new SectionNotFoundException("Not found section with id: " + productRequestDto.getSection().getId()));
        productRequestDto.getSection().setName(section.getName());

        Date date = new Date();

        Product product = productRequestDto.convertDtoToEntity();
        product.setDate(date);
        Product productResponse = productRepository.save(product);

        return productResponse.convertEntityToResponse();
    }

    public Page<ProductResponseDto> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable).map(Product::convertEntityToResponse);
    }

    public List<ProductResponseDto> getAllListedProducts() {
        return productRepository.findAll().stream()
                .map(Product::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponseDto getById(String id){

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Not found product with id " + id));
        return product.convertEntityToResponse();
    }

    public void deleteById(String id){
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ProductNotFoundException("Not found product with id " + id);
        }
    }

    public ProductResponseDto updateById(ProductUpdateDto productUpdateDto, String id){

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Not found product with id " + id));

        if(productUpdateDto.getName() != null){
            product.setName(productUpdateDto.getName());
        }

        if(productUpdateDto.getDescription() != null){
            product.setDescription(productUpdateDto.getDescription());
        }

        if(productUpdateDto.getValue() != null){
            product.setValue(productUpdateDto.getValue());
        }

        Product productResponse = productRepository.save(product);
        return productResponse.convertEntityToResponse();
    }

}
