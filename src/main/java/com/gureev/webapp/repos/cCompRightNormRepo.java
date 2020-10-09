package com.gureev.webapp.repos;

import com.gureev.webapp.domain.cCompRightNorm;
import org.springframework.data.repository.CrudRepository;

public interface cCompRightNormRepo extends CrudRepository<cCompRightNorm,Integer> {


    cCompRightNorm findById(Long id);

    void deleteById(Long id);
}
