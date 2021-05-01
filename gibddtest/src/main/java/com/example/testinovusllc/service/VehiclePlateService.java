package com.example.testinovusllc.service;

import com.example.testinovusllc.generation.IncreaseNumber;
import com.example.testinovusllc.generation.RandomNumber;
import com.example.testinovusllc.model.VehiclePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiclePlateService {

    @Autowired
    private IncreaseNumber increaseNumber;
    @Autowired
    private RandomNumber randomNumber;

    public String getRandom(){
        return randomNumber.mixNumber() + VehiclePlate.REGION;
    }

    public String getNext(){
        return increaseNumber.increaseNumber() + VehiclePlate.REGION;
    }












}
