package com.vivi.ch01.ch01_01;

import java.util.Enumeration;
import java.util.Vector;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public void set_priceCode(int arg) {
        switch (arg){
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price code");
        }
    }

    double getCharge(int daysRented){
        return _price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented){
        return _price.getFrequentRenterPoints(daysRented);
    }
}

class Rental{
    private Movie _movie;
    private int _dayRented;

    public Rental(Movie _movie, int _dayRented) {
        this._movie = _movie;
        this._dayRented = _dayRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_dayRented() {
        return _dayRented;
    }

    //determine amount
    public double getCharge(){
        return _movie.getCharge(_dayRented);
    }

    int getFrequentRenterPoints(){
        return _movie.getFrequentRenterPoints(_dayRented);
    }
}

class Customer{
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg){
        this._rentals.addElement(arg);
    }

    public String get_name() {
        return _name;
    }

    public String statement(){
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" +
                String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String .valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

abstract class Price{
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}

class ChildrensPrice extends Price{

    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    double getCharge(int daysRented){
        double result = 1.5;
        if(daysRented > 3)
            result +=  (daysRented -3) * 1.5;
        return result;
    }
}

class NewReleasePrice extends Price{

    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented){
        return daysRented * 3;
    }

    int getFrequentRenterPoints(int daysRented){
        return daysRented > 1 ? 2 : 1;
    }
}

class RegularPrice extends Price{

    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented){
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}