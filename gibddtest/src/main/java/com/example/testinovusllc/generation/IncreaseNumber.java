package com.example.testinovusllc.generation;

import com.example.testinovusllc.model.VehiclePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncreaseNumber {

    private VehiclePlate vehiclePlate;

    @Autowired
    public IncreaseNumber(VehiclePlate vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String increaseNumber(){
        if (GenerationNumber.checkNumber(vehiclePlate.getNumber())) return vehiclePlate.getNumber();

        int count = vehiclePlate.getCount();
        String number = vehiclePlate.getNumber();

        if(count == 999){
            count = 0;
            number = changedNumber().replaceAll("\\d", String.valueOf(count));
        }else {
            count++;
            number = GenerationNumber.getReplacedCount(count, number);
        }
        GenerationNumber.addNumber(vehiclePlate, count, number);
        GenerationNumber.checkNumber(number);
        return number;
    }

    private String changedNumber(){
        char[] chars = vehiclePlate.getNumber().toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i] == 'Х') {
                chars[i] = 'А';
            }else if (vehiclePlate.getAlphabet().contains(chars[i])){
                int idx = vehiclePlate.getAlphabet().indexOf(chars[i]) + 1;
                chars[i] = vehiclePlate.getAlphabet().get(idx);
                break;
            }
        }
        return new String(chars);
    }

}
