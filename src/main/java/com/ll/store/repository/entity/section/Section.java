package com.ll.store.repository.entity.section;

import com.ll.store.service.dto.section.SectionResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String section;

    public Section() {
    }

    public Section(String section) {

        this.section = section;
    }

    public SectionResponseDto convertEntityToResponseDto(){

        return new SectionResponseDto(id, section);
    }
};
