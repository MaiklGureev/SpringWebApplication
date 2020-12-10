package com.gureev.webapp.controller;

import com.gureev.webapp.model.cServiceSection;
import com.gureev.webapp.repos.cServiceSectionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class cServiceSectionController {
    private final cServiceSectionRepo serviceSectionRepo;

    public cServiceSectionController(cServiceSectionRepo serviceSectionRepo) {
        this.serviceSectionRepo = serviceSectionRepo;
    }

    @PostMapping("/ServiceSection/save")
    public ResponseEntity saveServiceSection(@RequestBody cServiceSection serviceSection) {
        try{
            serviceSectionRepo.save(serviceSection);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not saved!", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/ServiceSection/all")
    public ResponseEntity  getCompanies() {
        try{
            List<cServiceSection> list = (List<cServiceSection>) serviceSectionRepo.findAll();
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

    @GetMapping("/ServiceSection/byId")
    public ResponseEntity getServiceSection(@RequestParam Long id) {
        try{
            cServiceSection entity = serviceSectionRepo.findById(id).get();
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/ServiceSection/del")
    public ResponseEntity deleteServiceSectionById(@RequestParam Long id) {
        try{
            serviceSectionRepo.deleteById(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not modified!", HttpStatus.NOT_MODIFIED);
        }
    }

}
