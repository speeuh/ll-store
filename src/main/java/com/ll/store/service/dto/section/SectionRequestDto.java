package com.ll.store.service.dto.section;


import com.ll.store.repository.entity.section.Section;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionRequestDto {

    private String name;

    public SectionRequestDto(String name) {
        this.name = name;
    }

    public Section convertRequestDtoToEntity(){
        return new Section(name);
    }
};
