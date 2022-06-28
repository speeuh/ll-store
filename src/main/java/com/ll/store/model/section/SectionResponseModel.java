package com.ll.store.model.section;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionResponseModel {
    private String id;
    private String name;

    public SectionResponseModel(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
