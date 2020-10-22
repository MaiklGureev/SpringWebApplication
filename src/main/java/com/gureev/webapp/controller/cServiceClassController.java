package com.gureev.webapp.controller;

import com.gureev.webapp.model.cServiceClass;
import com.gureev.webapp.repos.cServiceClassRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class cServiceClassController {
    private final cServiceClassRepo serviceClassRepo;

    public cServiceClassController(cServiceClassRepo serviceClassRepo) {
        this.serviceClassRepo = serviceClassRepo;
    }

    @PostMapping("/ServiceClass/save")
    public ResponseEntity saveServiceClass(@RequestBody cServiceClass ServiceClass) {
        try{
            serviceClassRepo.save(ServiceClass);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not saved!", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/ServiceClass/all")
    public ResponseEntity  getCompanies() {
        try{
            List<cServiceClass> list = (List<cServiceClass>) serviceClassRepo.findAll();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entities not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ServiceClass/byId")
    public ResponseEntity getServiceClass(@RequestParam Long id) {
        try{
            cServiceClass entity = serviceClassRepo.findById(id).get();
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/ServiceClass/del")
    public ResponseEntity deleteServiceClassById(@RequestParam Long id) {
        try{
            serviceClassRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not modified!", HttpStatus.NOT_MODIFIED);
        }
    }

}
