package com.ll.store.service.dto.section;

import com.ll.store.model.section.SectionResponseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionResponseDto {

    private long id;
    private String section;

    public SectionResponseDto(long id, String section) {
        this.id = id;
        this.section = section;
    }

    public SectionResponseModel convertResponseDtoToModel() {
        return new SectionResponseModel(id, section);
    }
}
