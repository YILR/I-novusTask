package com.example.mimitest.controller;

import com.example.mimitest.entity.Cat;
import com.example.mimitest.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mimi",  produces = MediaType.APPLICATION_JSON_VALUE)
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/top10")
    public ResponseEntity<List<Cat>> getTop10(){
        List<Cat> cats = catService.getTop10();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @PostMapping("/choice/{id}")
    public void choiceCate(@PathVariable Long id){
        catService.updateCat(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cat>> getAll(){
        List<Cat> cats = catService.getAll();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }
}
