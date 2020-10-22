package com.gureev.webapp.repos;

import com.gureev.webapp.model.cServiceSection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface cServiceSectionRepo extends CrudRepository<cServiceSection,Long> {

    void deleteById(Long id);
    Optional<cServiceSection> findById(Long id);
}
