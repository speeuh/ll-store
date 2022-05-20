package com.ll.store.repository.entity.section;

import javax.persistence.*;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String section;

}
