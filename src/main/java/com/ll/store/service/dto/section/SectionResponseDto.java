package com.ll.store.service.dto.section;

import com.ll.store.model.section.SectionResponseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionResponseDto {
    private String id;
    private String name;

    public SectionResponseDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public SectionResponseModel convertResponseDtoToModel() {
        return new SectionResponseModel(id, name);
    }
}
