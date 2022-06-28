package com.ll.store.controller.brand;

import com.ll.store.model.brand.BrandRequestModel;
import com.ll.store.model.brand.BrandResponseModel;
import com.ll.store.model.brand.BrandUpdateModel;
import com.ll.store.service.brand.BrandService;
import com.ll.store.service.dto.brand.BrandRequestDto;
import com.ll.store.service.dto.brand.BrandResponseDto;
import com.ll.store.service.dto.brand.BrandUpdateDto;
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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping
    public ResponseEntity<Page<BrandResponseModel>> getAllBrands(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<BrandResponseDto> brandResponseDto = brandService.getAllBrands(pageable);
        return ResponseEntity.ok(brandResponseDto.map(BrandResponseDto::convertBrandResponseDtoToModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponseModel> getBrandById(@PathVariable String id){
        BrandResponseDto brandResponseDto = brandService.getBrandById(id);
        return ResponseEntity.ok(brandResponseDto.convertBrandResponseDtoToModel());
    }

    @GetMapping("/list")
    public ResponseEntity<List<BrandResponseModel>> getAllListedBrands() {
        List<BrandResponseDto> brandResponseDto = brandService.getAllListedBrands();
        return ResponseEntity.ok(brandResponseDto.stream()
                .map(BrandResponseDto::convertBrandResponseDtoToModel)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrandById(@PathVariable String id){
        brandService.deleteBrandById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BrandResponseModel> updateBrandById(@RequestBody BrandUpdateModel brandUpdateModel, @PathVariable String id, BindingResult result) throws Exception {
        try {
            if(result.hasErrors()){
                throw new IllegalArgumentException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            }

            BrandUpdateDto brandUpdateDto = brandUpdateModel.convertUpdateModelToDto();
            BrandResponseDto brandResponseDto = brandService.updateBrandById(brandUpdateDto, id);
            BrandResponseModel brandResponseModel = brandResponseDto.convertBrandResponseDtoToModel();

            return new ResponseEntity<>(brandResponseModel, HttpStatus.OK);

        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }
}
