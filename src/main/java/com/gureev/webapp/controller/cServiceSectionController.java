package com.gureev.webapp.controller;

import com.gureev.webapp.domain.cServiceClass;
import com.gureev.webapp.domain.cServiceSection;
import com.gureev.webapp.domain.sCompany;
import com.gureev.webapp.repos.cServiceSectionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/ServiceSection/all")
    public ResponseEntity  getCompanies() {
        try{
            List<cServiceSection> list = (List<cServiceSection>) serviceSectionRepo.findAll();
            if(!list.isEmpty()){
                return new ResponseEntity(list,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ServiceSection/byId")
    public ResponseEntity getServiceSection(@RequestParam Long id) {
        try{
            cServiceSection entity = serviceSectionRepo.findById(id);
            if(entity!=null){
                return new ResponseEntity(entity,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/ServiceSection/del")
    public ResponseEntity deleteServiceSectionById(@RequestParam Long id) {
        try{
            serviceSectionRepo.deleteById(id);
            return new ResponseEntity("Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

}
