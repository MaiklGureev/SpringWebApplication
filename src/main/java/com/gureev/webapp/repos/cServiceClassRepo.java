package com.gureev.webapp.repos;

import com.gureev.webapp.model.cServiceClass;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface cServiceClassRepo extends CrudRepository<cServiceClass,Long> {
    void deleteById(Long id);

    Optional<cServiceClass> findById(Long id);
}
