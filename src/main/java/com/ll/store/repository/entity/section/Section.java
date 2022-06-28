package com.ll.store.repository.entity.section;

import com.ll.store.service.dto.section.SectionResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public SectionResponseDto convertEntityToResponseDto(){
        return new SectionResponseDto(id, name);
    }
};
