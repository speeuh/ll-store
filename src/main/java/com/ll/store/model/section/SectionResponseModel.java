package com.ll.store.model.section;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionResponseModel {
    private long id;
    private String section;

    public SectionResponseModel(long id, String section) {
        this.id = id;
        this.section = section;
    }
}
