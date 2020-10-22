package com.gureev.webapp.repos;

import com.gureev.webapp.model.sAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface sAddressRepo extends CrudRepository<sAddress,Long> {

    void deleteById(Long id);

    Optional<sAddress> findById(Long id);
}
