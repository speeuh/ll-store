package com.ll.store.model.section;

import com.ll.store.service.dto.section.SectionUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateModel {
    private String name;

    public SectionUpdateDto convertUpdateModelToDto() {
        return new SectionUpdateDto(name);
    }
}
