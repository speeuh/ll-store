package com.ll.store.model.section;

import com.ll.store.service.dto.section.SectionRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class SectionRequestModel {

    @NotNull @NotBlank
    private String name;

    public SectionRequestDto convertRequestModelToDto(){
        return new SectionRequestDto(name);
    }
}
