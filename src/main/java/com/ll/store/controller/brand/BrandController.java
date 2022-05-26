package com.ll.store.controller.brand;

import com.ll.store.model.brand.BrandRequestModel;
import com.ll.store.model.brand.BrandResponseModel;
import com.ll.store.service.brand.BrandService;
import com.ll.store.service.dto.brand.BrandRequestDto;
import com.ll.store.service.dto.brand.BrandResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandResponseModel> createBrand(@RequestBody @Valid BrandRequestModel brandRequestModel){

        BrandRequestDto brandRequestDto = brandRequestModel.convertBrandRequestModelToDto();
        BrandResponseDto brandResponseDto = brandService.createBrand(brandRequestDto);
        BrandResponseModel brandResponseModel = brandResponseDto.convertBrandResponseDtoToModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(brandResponseModel);
    }
}
