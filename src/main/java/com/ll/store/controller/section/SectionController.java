package com.ll.store.controller.section;

import com.ll.store.model.section.SectionRequestModel;
import com.ll.store.model.section.SectionResponseModel;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import com.ll.store.service.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
