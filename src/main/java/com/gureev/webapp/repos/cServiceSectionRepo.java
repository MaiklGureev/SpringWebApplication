package com.gureev.webapp.repos;

import com.gureev.webapp.domain.cServiceSection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface cServiceSectionRepo extends CrudRepository<cServiceSection,Integer> {

    void deleteById(Long id);
    cServiceSection findById(Long id);
}
