package com.ll.store.service.brand;

import com.ll.store.config.validation.exceptions.BrandNotFoundException;
import com.ll.store.repository.brand.BrandRepository;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.service.dto.brand.BrandRequestDto;
import com.ll.store.service.dto.brand.BrandResponseDto;
import com.ll.store.service.dto.brand.BrandUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandResponseDto createBrand(BrandRequestDto brandRequestDto){

        Brand brand = brandRequestDto.convertBrandDtoToEntity();
        Brand brandResponse = brandRepository.save(brand);

        return brandResponse.convertBrandEntityToResponseDto();
    }

    public Page<BrandResponseDto> getAllBrands(Pageable pageable){
        return brandRepository.findAll(pageable).map(Brand::convertBrandEntityToResponseDto);
    }

    public BrandResponseDto getBrandById(long id){

        Brand brand = brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException("Not found brand with id: " + id));
        return brand.convertBrandEntityToResponseDto();
    }

    public void deleteBrandById(long id){

        try {
            brandRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new BrandNotFoundException("Not found brand with id: " + id);
        }

    }

    public BrandResponseDto updateBrandById(BrandUpdateDto brandUpdateDto, long id){

        Brand brand = brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException("Not found brand with id: " + id));

        if(brandUpdateDto.getBrandName() != null){
            brand.setBrandName(brandUpdateDto.getBrandName());
        }

        Brand brandResponse = brandRepository.save(brand);
        return brandResponse.convertBrandEntityToResponseDto();
    }
}
