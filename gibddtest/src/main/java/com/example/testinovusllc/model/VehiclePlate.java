package com.example.testinovusllc.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class VehiclePlate {

    public static final String REGION = " 116 RUS";

    private List<Character> alphabet = new ArrayList<>(Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'));
    private String number = "А000АА";
    private int count = 0;

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
