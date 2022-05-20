package com.ll.store.service.dto.section;


import com.ll.store.repository.entity.section.Section;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionRequestDto {

    private String section;

    public SectionRequestDto(String section) {
        this.section = section;
    }

    public Section convertRequestDtoToEntity(){
        return new Section(section);
    }
};
