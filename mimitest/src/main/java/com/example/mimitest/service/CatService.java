package com.example.mimitest.service;

import com.example.mimitest.entity.Cat;
import com.example.mimitest.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CatService {


    @Autowired
    private CatRepository catRepository;


    public List<Cat> getTop10(){
        return catRepository.findTop10ByOrderByLikesDesc();
    }

    public void updateCat(Long id){
       Cat cat = catRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Cat"));
       cat.setLikes(cat.getLikes() +1);
       catRepository.save(cat);
    }

    public List<Cat> getAll(){
        List<Cat> cats = catRepository.findAll();
        Collections.shuffle(cats);
        return cats;
    }

}
