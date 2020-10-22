package com.gureev.webapp.controller;


import com.gureev.webapp.model.sCompany;
import com.gureev.webapp.repos.sCompanyRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class sCompanyController {

    private final sCompanyRepo sCompanyRepo;

    public sCompanyController(sCompanyRepo sCompanyRepo) {
        this.sCompanyRepo = sCompanyRepo;
    }

    @PostMapping("/Company/save")
    public ResponseEntity saveCompany(@RequestBody sCompany company) {
        try {
            sCompanyRepo.save(company);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not saved!", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/Company/all")
    public ResponseEntity getCompanies() {
        try {
            List<sCompany> list = (List<sCompany>) sCompanyRepo.findAll();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entities not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Company/byId")
    public ResponseEntity getCompany(@RequestParam Long id) {
        try {
            sCompany entity = sCompanyRepo.findById(id).get();
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Company/del")
    public ResponseEntity deleteCompanyById(@RequestParam Long id) {
        try {
            sCompanyRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not modified!", HttpStatus.NOT_MODIFIED);
        }
    }


}
