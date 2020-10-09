package com.gureev.webapp.controller;


import com.gureev.webapp.domain.cServiceClass;
import com.gureev.webapp.domain.sCompany;
import com.gureev.webapp.repos.sCompanyRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class sCompanyController {

    private final sCompanyRepo sCompanyRepo;

    public sCompanyController(sCompanyRepo sCompanyRepo) {
        this.sCompanyRepo = sCompanyRepo;
    }

    @PostMapping("/Company/save")
    public ResponseEntity saveCompany(@RequestBody sCompany company) {
        try{
            sCompanyRepo.save(company);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/Company/all")
    public ResponseEntity  getCompanies() {
        try{
            List<sCompany> list = (List<sCompany>) sCompanyRepo.findAll();
            if(!list.isEmpty()){
                return new ResponseEntity(list,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Company/byId")
    public ResponseEntity getCompany(@RequestParam Long id) {
        try{
            sCompany entity = sCompanyRepo.findById(id);
            if(entity!=null){
                return new ResponseEntity(entity,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Company/del")
    public ResponseEntity deleteCompanyById(@RequestParam Long id) {
        try{
            sCompanyRepo.deleteById(id);
            return new ResponseEntity("Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }


}
