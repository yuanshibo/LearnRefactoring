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

            thisAmonut = each.getCharge();

            frequentRenterPoints += each.getFrequentRenterPoints();

            result += String.format("\t%s\t%s\n", each.getMovie().getTitle(),String.valueOf(thisAmonut));
            totalAmount += thisAmonut;

        }

        result += String.format("Amonut owed is %s\n", String.valueOf(totalAmount));
        result += String.format("You earned %d frequent renter points\n", frequentRenterPoints);

        return result;
    }
    
}
