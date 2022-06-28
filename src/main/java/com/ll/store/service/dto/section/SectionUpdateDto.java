package com.ll.store.service.dto.section;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateDto {
    private String name;

    public SectionUpdateDto(String name) {
        this.name = name;
    }
}
