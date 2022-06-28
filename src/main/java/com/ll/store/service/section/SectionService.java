package com.ll.store.service.section;

import com.ll.store.config.validation.exceptions.SectionNotFoundException;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.repository.section.SectionRepository;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import com.ll.store.service.dto.section.SectionUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {
    
    @Autowired
    private SectionRepository sectionRepository;

    public SectionResponseDto createSection(SectionRequestDto sectionRequestDto) {

        Section section = sectionRequestDto.convertRequestDtoToEntity();
        Section sectionResponse = sectionRepository.save(section);

        return sectionResponse.convertEntityToResponseDto();
    }

    public Page<SectionResponseDto> getAllSections(Pageable pageable) {
        return sectionRepository.findAll(pageable).map(Section::convertEntityToResponseDto);
    }

    public SectionResponseDto getSectionById(String id) {
        Section section = sectionRepository.findById(id).orElseThrow(() -> new SectionNotFoundException("Not found section with id " + id));
        return section.convertEntityToResponseDto();
    }

    public List<SectionResponseDto> getAllListedSections() {
        return sectionRepository.findAll().stream()
                .map(Section::convertEntityToResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteSectionById(String id) {

        try{
            sectionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new SectionNotFoundException("Not found section with id " + id);
        }
    }

    public SectionResponseDto updateSectionById(SectionUpdateDto sectionUpdateDto, String id) {
        Section section = sectionRepository.findById(id).orElseThrow(()-> new SectionNotFoundException("Not found section with id " + id));

        if(sectionUpdateDto.getName() != null) {
            section.setName(sectionUpdateDto.getName());
        }

        Section sectionResponse = sectionRepository.save(section);
         return sectionResponse.convertEntityToResponseDto();
    }


}
