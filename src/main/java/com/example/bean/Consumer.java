package com.example.bean;

import java.util.Enumeration;
import java.util.Vector;

public class Consumer {
    private String _name;
    public Consumer(String name) {
        this._name = name;
    }
    public String getName() {
        return _name;
    }
    private Vector<Rental>_retals =new Vector<Rental>();

    public void addRental(Rental arg){
        _retals.addElement(arg);
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _retals.elements();

        String result = String.format("Rental Record for %s\n",getName());

        while(rentals.hasMoreElements()){
            double thisAmonut = 0;
            Rental each = (Rental)rentals.nextElement();

            switch(each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmonut += 2;
                    if(each.getDaysRented() > 2){
                        thisAmonut += (each.getDaysRented() -2 ) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmonut +=each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmonut += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmonut += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            frequentRenterPoints ++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1){
                frequentRenterPoints ++;
            }

            result += String.format("\t%s\t%s\n", each.getMovie().getTitle(),String.valueOf(thisAmonut));
            totalAmount += thisAmonut;

        }

        result += String.format("Amonut owed is %s\n", String.valueOf(totalAmount));
        result += String.format("You earned %d frequent renter points\n", frequentRenterPoints);

        return result;
    }

    
    
}
