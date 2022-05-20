package com.ll.store.controller.product;

import com.ll.store.model.product.ProductRequestModel;
import com.ll.store.model.product.ProductResponseModel;
import com.ll.store.service.dto.product.ProductRequestDto;
import com.ll.store.service.dto.product.ProductResponseDto;
import com.ll.store.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseModel> createProduct(@RequestBody @Valid ProductRequestModel productRequestModel){

        ProductRequestDto productRequestDto = productRequestModel.convertRequestModelToDto();
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto);
        ProductResponseModel productResponseModel = productResponseDto.convertResponseDtoToResponseModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseModel);

    }
}
