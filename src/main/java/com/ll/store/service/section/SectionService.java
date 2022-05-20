package com.ll.store.service.section;

import com.ll.store.repository.entity.section.Section;
import com.ll.store.repository.section.SectionRepository;
import com.ll.store.service.dto.section.SectionRequestDto;
import com.ll.store.service.dto.section.SectionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
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
}
