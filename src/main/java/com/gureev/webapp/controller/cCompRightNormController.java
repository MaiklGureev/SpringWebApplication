package com.gureev.webapp.controller;

import com.gureev.webapp.model.cCompRightNorm;
import com.gureev.webapp.repos.cCompRightNormRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
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
        } catch (Exception e) {
            return new ResponseEntity("Entity not saved!", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/CompRightNorm/all")
    public ResponseEntity  getCompRightNorms() {
        try{
            List<cCompRightNorm> list = (List<cCompRightNorm>) compRightNormRepo.findAll();
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

    @GetMapping("/CompRightNorm/ById")
    public ResponseEntity getCompRightNorm(@RequestParam Long id) {
        try{
            cCompRightNorm entity = compRightNormRepo.findById(id).get();
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/CompRightNorm/del")
    public ResponseEntity deleteCompRightNorm(@RequestParam Long id) {
        try{
            compRightNormRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Entity not modified!", HttpStatus.NOT_MODIFIED);
        }
    }
}
