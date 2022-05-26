package com.ll.store.service.brand;

import com.ll.store.repository.brand.BrandRepository;
import com.ll.store.repository.entity.brand.Brand;
import com.ll.store.service.dto.brand.BrandRequestDto;
import com.ll.store.service.dto.brand.BrandResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
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
}
