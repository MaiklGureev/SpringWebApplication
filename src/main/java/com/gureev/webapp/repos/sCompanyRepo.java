package com.gureev.webapp.repos;

import com.gureev.webapp.domain.sCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface sCompanyRepo extends CrudRepository<sCompany,Integer> {

    sCompany findById(Long id);
    void deleteById(Long id);
}
