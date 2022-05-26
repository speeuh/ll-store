package com.ll.store.controller.product;

import com.ll.store.model.product.ProductRequestModel;
import com.ll.store.model.product.ProductResponseModel;
import com.ll.store.model.product.ProductUpdateModel;
import com.ll.store.service.dto.product.ProductRequestDto;
import com.ll.store.service.dto.product.ProductResponseDto;
import com.ll.store.service.dto.product.ProductUpdateDto;
import com.ll.store.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Objects;

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

    @GetMapping
    public ResponseEntity<Page<ProductResponseModel>> getAllProducts(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<ProductResponseDto> productResponseDto = productService.getAllProducts(pageable);
        return ResponseEntity.ok(productResponseDto.map(ProductResponseDto::convertResponseDtoToResponseModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getById(@PathVariable long id){

        ProductResponseDto productResponseDto = productService.getById(id);
        return ResponseEntity.ok(productResponseDto.convertResponseDtoToResponseModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseModel> updateProductById(@RequestBody @Valid ProductUpdateModel productUpdateModel, @PathVariable long id, BindingResult result) throws Exception{

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
