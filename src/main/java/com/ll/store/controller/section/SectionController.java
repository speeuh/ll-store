package com.ll.store.controller.section;

import com.ll.store.model.section.SectionRequestModel;
import com.ll.store.model.section.SectionResponseModel;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import com.ll.store.service.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    public  SectionService sectionService;

    @PostMapping
    public ResponseEntity<SectionResponseModel> createSection(@RequestBody @Valid SectionRequestModel sectionRequestModel) {

        SectionRequestDto sectionRequestDto = sectionRequestModel.convertRequestModelToDto();
        SectionResponseDto sectionResponseDto = sectionService.createSection(sectionRequestDto);
        SectionResponseModel sectionResponseModel = sectionResponseDto.convertResponseDtoToModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(sectionResponseModel);
    }

    @GetMapping
    public ResponseEntity<Page<SectionResponseModel>> getAllSections(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {

        Page<SectionResponseDto> sectionResponseDto = sectionService.getAllSections(pageable);

        return  ResponseEntity.ok(sectionResponseDto.map(SectionResponseDto::convertResponseDtoToModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionResponseModel> getSectionById(@PathVariable long id) {
       SectionResponseDto sectionResponseDto = sectionService.getSectionById(id);

        return ResponseEntity.ok(sectionResponseDto.convertResponseDtoToModel());

    }
}
