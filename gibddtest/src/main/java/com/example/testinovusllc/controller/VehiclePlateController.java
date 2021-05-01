package com.example.testinovusllc.controller;

import com.example.testinovusllc.service.VehiclePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class VehiclePlateController {

    @Autowired
    private VehiclePlateService vehiclePlateService;

    @GetMapping("/random")
    public String getRandom(){
        return vehiclePlateService.getRandom();
    }

    @GetMapping("/next")
    public String getNext(){
        return vehiclePlateService.getNext();
    }
}
