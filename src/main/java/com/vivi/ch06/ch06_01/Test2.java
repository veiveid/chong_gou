package com.vivi.ch06.ch06_01;

public class Test2 {
    int _quantity = 10;
    int _itemPrice = 5;

    /**
    double getPrice(){
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if(basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }
     */

    //     ||
    //     ||
    //    \||/
    //     \/

    double getPrice2(){
        int basePrice = basePrice();
        double discountFactor;
        if(basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }

    private int basePrice(){
        return _quantity * _itemPrice;
    }


    //     ||
    //     ||
    //    \||/
    //     \/

    double getPrice3(){
        double discountFactor;
        if(basePrice() > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice() * discountFactor;
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double getPrice4(){
        double discountFactor = discountFactor();
        return basePrice() * discountFactor;
    }

    private double discountFactor(){
        if (basePrice() > 1000) return 0.95;
        else return 0.98;
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double getPrice5(){
        return basePrice() * discountFactor();
    }

}