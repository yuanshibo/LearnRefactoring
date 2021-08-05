package com.example.logic;

import com.example.bean.Consumer;
import com.example.bean.Movie;
import com.example.bean.Rental;

public class HelloWorld {

    public static void main(String[] args) {
        Rental retal1 = new Rental(new Movie("Childrens Movie",Movie.CHILDRENS), 5);
        Rental retal2 = new Rental(new Movie("new Release Movie",Movie.NEW_RELEASE), 6);
        Rental retal3 = new Rental(new Movie("Regular Movie",Movie.REGULAR), 6);
        
        Consumer consumer = new Consumer("yuan shibo");
        consumer.addRental(retal1);
        consumer.addRental(retal2);
        consumer.addRental(retal3);
        System.out.print(consumer.statement());;
        System.exit(0);
    }

}