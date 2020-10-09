package com.gureev.webapp.repos;

import com.gureev.webapp.domain.cServiceClass;
import org.springframework.data.repository.CrudRepository;

public interface cServiceClassRepo extends CrudRepository<cServiceClass,Integer> {
    void deleteById(Long id);

    cServiceClass findById(Long id);
}
