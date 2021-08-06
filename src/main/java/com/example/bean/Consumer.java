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
        Enumeration<Rental> rentals = _retals.elements();

        String result = String.format("Rental Record for %s\n",getName());

        while(rentals.hasMoreElements()){
            Rental each = (Rental)rentals.nextElement();

            result += String.format("\t%s\t%s\n", each.getMovie().getTitle(),String.valueOf(each.getCharge()));

        }

        result += String.format("Amonut owed is %s\n", String.valueOf(getTotalAmount()));
        result += String.format("You earned %d frequent renter points\n", getTotalFrequentRenterPoints());

        return result;
    }
    private double getTotalAmount() {
        double result = 0; 
        Enumeration<Rental> rentals = _retals.elements();
        while(rentals.hasMoreElements()){
            Rental each = (Rental)rentals.nextElement();

            result += each.getCharge();

        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0; 
        Enumeration<Rental> rentals = _retals.elements();
        while(rentals.hasMoreElements()){
            Rental each = (Rental)rentals.nextElement();

            result += each.getFrequentRenterPoints();

        }
        return result;
    }
    
}
