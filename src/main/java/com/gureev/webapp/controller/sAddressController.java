package com.gureev.webapp.controller;


import com.gureev.webapp.domain.cServiceSection;
import com.gureev.webapp.domain.sAddress;
import com.gureev.webapp.repos.sAddressRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class sAddressController {
    private final sAddressRepo addressRepo;

    public sAddressController(sAddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @PostMapping("/Address/save")
    public ResponseEntity saveAddress(@RequestBody sAddress address) {
        try{
            addressRepo.save(address);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/Address/all")
    public ResponseEntity  getCompanies() {
        try{
            List<sAddress> list = (List<sAddress>) addressRepo.findAll();
            if(!list.isEmpty()){
                return new ResponseEntity(list,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Address/byId")
    public ResponseEntity getAddress(@RequestParam Long id) {
        try{
            sAddress entity = addressRepo.findById(id);
            if(entity!=null){
                return new ResponseEntity(entity,HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Address/del")
    public ResponseEntity deleteAddressById(@RequestParam Long id) {
        try{
            addressRepo.deleteById(id);
            return new ResponseEntity("Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
