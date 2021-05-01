package com.example.testinovusllc;

import com.example.testinovusllc.generation.GenerationNumber;
import com.example.testinovusllc.generation.IncreaseNumber;
import com.example.testinovusllc.generation.RandomNumber;
import com.example.testinovusllc.model.VehiclePlate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TestINovusLlcApplicationTests {

	@Autowired
	private VehiclePlate vehiclePlate;
	@Autowired
	private IncreaseNumber increaseNumber;
	@Autowired
	private RandomNumber randomNumber;


	@Test
	public void test1(){
		vehiclePlate.setCount(999);
		vehiclePlate.setNumber("Х999ХХ");
		increaseNumber.increaseNumber();
		String oldNum = increaseNumber.increaseNumber();
		Assertions.assertEquals("А000АА", oldNum);
	}


	@Test
	public void test2(){
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(randomNumber.mixNumber());
		}
		Assertions.assertTrue(GenerationNumber.getNumbers().containsAll(list));
	}

	@Test
	public void test3(){
		vehiclePlate.setCount(999);
		vehiclePlate.setNumber("С999ВА");
		increaseNumber.increaseNumber();
		String oldNum = increaseNumber.increaseNumber();
		Assertions.assertEquals("С000ВВ", oldNum);
	}

	@Test
	public void test4(){
		String randNum = randomNumber.mixNumber();
		int count = Integer.parseInt(randNum.replaceAll("[А-Я]", ""));
		String inNum = increaseNumber.increaseNumber();
		if(count == 999)
			test4();
		count++;
		String nextNum = GenerationNumber.getReplacedCount(count, randNum);
		Assertions.assertEquals(nextNum, inNum);
	}

}
