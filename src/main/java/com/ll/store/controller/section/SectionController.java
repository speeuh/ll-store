package com.ll.store.controller.section;

import com.ll.store.model.section.SectionRequestModel;
import com.ll.store.model.section.SectionResponseModel;
import com.ll.store.model.section.SectionUpdateModel;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import com.ll.store.service.dto.section.SectionUpdateDto;
import com.ll.store.service.section.SectionService;
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
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    public  SectionService sectionService;

    @PostMapping
    @Caching(evict = {
            @CacheEvict(value = "pageSections", allEntries = true),
            @CacheEvict(value = "listSections", allEntries = true)
    })
    public ResponseEntity<SectionResponseModel> createSection(@RequestBody @Valid SectionRequestModel sectionRequestModel) {

        SectionRequestDto sectionRequestDto = sectionRequestModel.convertRequestModelToDto();
        SectionResponseDto sectionResponseDto = sectionService.createSection(sectionRequestDto);
        SectionResponseModel sectionResponseModel = sectionResponseDto.convertResponseDtoToModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(sectionResponseModel);
    }

    @GetMapping
    @Cacheable(value = "pageSections")
    public ResponseEntity<Page<SectionResponseModel>> getAllSections(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {

        Page<SectionResponseDto> sectionResponseDto = sectionService.getAllSections(pageable);

        return  ResponseEntity.ok(sectionResponseDto.map(SectionResponseDto::convertResponseDtoToModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionResponseModel> getSectionById(@PathVariable String id) {
       SectionResponseDto sectionResponseDto = sectionService.getSectionById(id);

        return ResponseEntity.ok(sectionResponseDto.convertResponseDtoToModel());

    }

    @GetMapping("/list")
    @Cacheable(value = "listSections")
    public ResponseEntity<List<SectionResponseModel>> getAllListedSections() {
        List<SectionResponseDto> sectionResponseDto = sectionService.getAllListedSections();
        return ResponseEntity.ok(sectionResponseDto.stream()
                .map(SectionResponseDto::convertResponseDtoToModel)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    @Caching(evict = {
            @CacheEvict(value = "pageSections", allEntries = true),
            @CacheEvict(value = "listSections", allEntries = true)
    })
    public ResponseEntity<String> deleteSectionById(@PathVariable String id) {
         sectionService.deleteSectionById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    @Caching(evict = {
            @CacheEvict(value = "pageSections", allEntries = true),
            @CacheEvict(value = "listSections", allEntries = true)
    })
    public ResponseEntity<SectionResponseModel> updateSectionById(@PathVariable String id, @RequestBody SectionUpdateModel sectionUpdateModel, BindingResult result) throws Exception {
       try {
           if (result.hasErrors()) {
               throw new IllegalArgumentException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
           }
           SectionUpdateDto sectionUpdateDto = sectionUpdateModel.convertUpdateModelToDto();
           SectionResponseDto sectionResponseDto = sectionService.updateSectionById(sectionUpdateDto, id);
           SectionResponseModel sectionResponseModel = sectionResponseDto.convertResponseDtoToModel();

           return new ResponseEntity<>(sectionResponseModel, HttpStatus.OK);
       } catch (IllegalArgumentException e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
       }
    }

}
