package com.gureev.webapp.controller;

import com.gureev.webapp.domain.cCompRightNorm;
import com.gureev.webapp.domain.sCompany;
import com.gureev.webapp.repos.cCompRightNormRepo;
import com.gureev.webapp.repos.sCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class cCompRightNormController {
    private final cCompRightNormRepo compRightNormRepo;

    public cCompRightNormController(cCompRightNormRepo compRightNormRepo) {
        this.compRightNormRepo = compRightNormRepo;
    }

    @PostMapping("/CompRightNorm/save")
    public ResponseEntity saveCompRightNorm(@RequestBody cCompRightNorm compRightNorm) {
        try{
            compRightNormRepo.save(compRightNorm);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/CompRightNorm/all")
    public ResponseEntity  getCompRightNorms() {
        try{
            List<cCompRightNorm> list = (List<cCompRightNorm>) compRightNormRepo.findAll();
            if(!list.isEmpty()){
                return new ResponseEntity(list,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/CompRightNorm/ById")
    public ResponseEntity getCompRightNorm(@RequestParam Long id) {
        try{
            cCompRightNorm entity = compRightNormRepo.findById(id);
            if(entity!=null){
                return new ResponseEntity(entity,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/CompRightNorm/del")
    public ResponseEntity deleteCompRightNorm(@RequestParam Long id) {
        try{
            compRightNormRepo.deleteById(id);
            return new ResponseEntity("Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
