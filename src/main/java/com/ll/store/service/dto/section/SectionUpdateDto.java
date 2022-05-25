package com.ll.store.service.dto.section;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateDto {
    private String section;


    public SectionUpdateDto(String section) {
        this.section = section;
    }
}
