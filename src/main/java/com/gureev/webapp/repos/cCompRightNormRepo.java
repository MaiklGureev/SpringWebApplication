package com.gureev.webapp.repos;

import com.gureev.webapp.model.cCompRightNorm;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface cCompRightNormRepo extends CrudRepository<cCompRightNorm,Long> {


    Optional<cCompRightNorm> findById(Long id);

    void deleteById(Long id);
}
