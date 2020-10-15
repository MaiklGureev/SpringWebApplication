package com.gureev.webapp.controller;

import com.gureev.webapp.domain.cServiceClass;
import com.gureev.webapp.domain.sCompany;
import com.gureev.webapp.repos.cServiceClassRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/ServiceClass/all")
    public ResponseEntity  getCompanies() {
        try{
            List<cServiceClass> list = (List<cServiceClass>) serviceClassRepo.findAll();
            if(!list.isEmpty()){
                return new ResponseEntity(list,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ServiceClass/byId")
    public ResponseEntity getServiceClass(@RequestParam Long id) {
        try{
            cServiceClass entity = serviceClassRepo.findById(id);
            if(entity!=null){
                return new ResponseEntity(entity,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/ServiceClass/del")
    public ResponseEntity deleteServiceClassById(@RequestParam Long id) {
        try{
            serviceClassRepo.deleteById(id);
            return new ResponseEntity("Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

}
