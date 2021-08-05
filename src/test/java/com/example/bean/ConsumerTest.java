package com.example.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConsumerTest {

	@Test
	public void testStatement() throws Exception {
        Rental retal1 = new Rental(new Movie("Childrens Movie",Movie.CHILDRENS), 3);
        Rental retal2 = new Rental(new Movie("Childrens Movie",Movie.CHILDRENS), 5);
        Rental retal3 = new Rental(new Movie("new Release Movie",Movie.NEW_RELEASE), 6);
        Rental retal4 = new Rental(new Movie("Regular Movie",Movie.REGULAR), 1);
        Rental retal5 = new Rental(new Movie("Regular Movie",Movie.REGULAR), 6);
        
        Consumer consumer = new Consumer("yuan shibo");
        consumer.addRental(retal1);
        consumer.addRental(retal2);
        consumer.addRental(retal3);
        consumer.addRental(retal4);
        consumer.addRental(retal5);


        String result = consumer.statement();
        System.out.println(result);

        String result1 = "Rental Record for yuan shibo\n";
        result1 += "\tChildrens Movie\t1.5\n";
        result1 += "\tChildrens Movie\t4.5\n";
        result1 += "\tnew Release Movie\t18.0\n";
        result1 += "\tRegular Movie\t2.0\n";
        result1 += "\tRegular Movie\t8.0\n";
        result1 += "Amonut owed is 34.0\n";
        result1 += "You earned 6 frequent renter points\n";

        assertTrue(result.equals(result1));   
        

	}

}
