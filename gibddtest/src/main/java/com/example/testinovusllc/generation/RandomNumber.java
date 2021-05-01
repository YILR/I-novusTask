package com.example.testinovusllc.generation;

import com.example.testinovusllc.model.VehiclePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {

    private VehiclePlate vehiclePlate;
    private Random random = new Random();

    @Autowired
    public RandomNumber(VehiclePlate vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String mixNumber(){
        int count = random.nextInt(999);
        char[] chars = vehiclePlate.getNumber().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(vehiclePlate.getAlphabet().contains(chars[i])){
                chars[i] = vehiclePlate.getAlphabet().get(random.nextInt(vehiclePlate.getAlphabet().size()-1));
            }
        }

        String number = GenerationNumber.getReplacedCount(count, String.valueOf(chars));
        GenerationNumber.addNumber(vehiclePlate, count, number);
        if(!GenerationNumber.checkNumber(number)) return mixNumber();
        return number;
    }
}
