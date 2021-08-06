package com.example.bean;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }

    public double getCharge(){
        return getMovie()._price.getCharge(getDaysRented());
    }
    
    public int getFrequentRenterPoints() {
        return getMovie()._price.getFrequentRenterPoints(getDaysRented());
    }
   
}
