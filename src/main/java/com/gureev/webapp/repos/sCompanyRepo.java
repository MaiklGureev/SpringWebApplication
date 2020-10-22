package com.gureev.webapp.repos;

import com.gureev.webapp.model.sCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface sCompanyRepo extends CrudRepository<sCompany,Long> {

    Optional<sCompany> findById(Long id);
    void deleteById(Long id);
}
