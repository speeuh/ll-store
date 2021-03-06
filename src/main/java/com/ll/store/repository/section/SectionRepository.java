package com.ll.store.repository.section;

import com.ll.store.repository.entity.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
