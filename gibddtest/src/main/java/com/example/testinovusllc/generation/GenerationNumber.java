package com.example.testinovusllc.generation;

import com.example.testinovusllc.model.VehiclePlate;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerationNumber {

    private static Set<String> numbers = new HashSet<>();

    public static void addNumber(VehiclePlate vehiclePlate, int count, String number) {
        vehiclePlate.setCount(count);
        vehiclePlate.setNumber(number);
    }

    public static boolean checkNumber(String number) {
        return numbers.add(number);
    }

    public static String getReplacedCount(int count, String num) {
        Pattern pattern = Pattern.compile("\\d{1,"+String.valueOf(count).length()+"}(?=[А-Я])");
        Matcher matcher = pattern.matcher(num);
        matcher.useTransparentBounds(true);
        num = matcher.replaceAll(String.valueOf(count));
        return num;
    }

    public static Set<String> getNumbers() {
        return new HashSet<>(numbers);
    }
}
