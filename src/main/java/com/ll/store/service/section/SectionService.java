package com.ll.store.service.section;

import com.ll.store.config.validation.exceptions.SectionNotFoundException;
import com.ll.store.repository.entity.section.Section;
import com.ll.store.repository.section.SectionRepository;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public SectionResponseDto getSectionById(long id) {
        Section section = sectionRepository.findById(id).orElseThrow(() -> new SectionNotFoundException("Not found section with id " + id));
        return section.convertEntityToResponseDto();
    }
}
