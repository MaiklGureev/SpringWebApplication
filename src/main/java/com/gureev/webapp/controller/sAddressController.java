package com.gureev.webapp.controller;


import com.gureev.webapp.model.sAddress;
import com.gureev.webapp.repos.sAddressRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class sAddressController {
    private final sAddressRepo addressRepo;

    public sAddressController(sAddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @PostMapping("/Address/save")
    public ResponseEntity saveAddress(@RequestBody sAddress address) {
//        try {
        addressRepo.save(address);
        return new ResponseEntity(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity("Entity not saved!", HttpStatus.NOT_MODIFIED);
//        }
    }

    @GetMapping("/Address/all")
    public ResponseEntity getCompanies() {
        try {
            List<sAddress> list = (List<sAddress>) addressRepo.findAll();
            list.sort((o1, o2) -> {
                if (o1.getId() > o2.getId()) {
                    return -1;
                }
                return 1;
            });
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entities not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Address/byId")
    public ResponseEntity getAddress(@RequestParam Long id) {
        try {
            sAddress entity = addressRepo.findById(id).get();
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Address/del")
    public ResponseEntity deleteAddressById(@RequestParam Long id) {
        try {
            addressRepo.deleteById(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not modified!", HttpStatus.NOT_MODIFIED);
        }
    }
}
