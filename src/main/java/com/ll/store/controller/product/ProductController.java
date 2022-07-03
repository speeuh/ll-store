package com.ll.store.controller.product;

import com.ll.store.model.product.ProductRequestModel;
import com.ll.store.model.product.ProductResponseModel;
import com.ll.store.model.product.ProductUpdateModel;
import com.ll.store.service.dto.product.ProductRequestDto;
import com.ll.store.service.dto.product.ProductResponseDto;
import com.ll.store.service.dto.product.ProductUpdateDto;
import com.ll.store.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Caching(evict = {
            @CacheEvict(value = "pageProducts", allEntries = true),
            @CacheEvict(value = "listProducts", allEntries = true)
    })
    public ResponseEntity<ProductResponseModel> createProduct(@RequestBody @Valid ProductRequestModel productRequestModel){

        ProductRequestDto productRequestDto = productRequestModel.convertRequestModelToDto();
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto);
        ProductResponseModel productResponseModel = productResponseDto.convertResponseDtoToResponseModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseModel);
    }

    @GetMapping
    @Cacheable(value = "pageProducts")
    public ResponseEntity<Page<ProductResponseModel>> getAllProducts(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<ProductResponseDto> productResponseDto = productService.getAllProducts(pageable);
        return ResponseEntity.ok(productResponseDto.map(ProductResponseDto::convertResponseDtoToResponseModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getById(@PathVariable String id){

        ProductResponseDto productResponseDto = productService.getById(id);
        return ResponseEntity.ok(productResponseDto.convertResponseDtoToResponseModel());
    }

    @GetMapping("/list")
    @Cacheable(value = "listProducts")
    public ResponseEntity<List<ProductResponseModel>> getAllListedProducts() {
        List<ProductResponseDto> productResponseDto = productService.getAllListedProducts();
        return ResponseEntity.ok(productResponseDto.stream()
                .map(ProductResponseDto::convertResponseDtoToResponseModel)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    @Caching(evict = {
            @CacheEvict(value = "pageProducts", allEntries = true),
            @CacheEvict(value = "listProducts", allEntries = true)
    })
    public ResponseEntity<String> deleteProductById(@PathVariable String id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    @Caching(evict = {
            @CacheEvict(value = "pageProducts", allEntries = true),
            @CacheEvict(value = "listProducts", allEntries = true)
    })
    public ResponseEntity<ProductResponseModel> updateProductById(@RequestBody @Valid ProductUpdateModel productUpdateModel, @PathVariable String id, BindingResult result) throws Exception{

        try {
            if(result.hasErrors()){
                throw new IllegalArgumentException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            }

            ProductUpdateDto productUpdateDto = productUpdateModel.convertUpdateModelToDto();
            ProductResponseDto productResponseDto = productService.updateById(productUpdateDto, id);
            ProductResponseModel productResponseModel = productResponseDto.convertResponseDtoToResponseModel();

            return new ResponseEntity<>(productResponseModel, HttpStatus.OK);

        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
