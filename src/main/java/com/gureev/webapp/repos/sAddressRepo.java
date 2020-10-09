package com.gureev.webapp.repos;

import com.gureev.webapp.domain.sAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface sAddressRepo extends CrudRepository<sAddress,Integer> {

    void deleteById(Long id);

    sAddress findById(Long id);
}
