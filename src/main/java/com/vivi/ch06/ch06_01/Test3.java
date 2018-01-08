package com.vivi.ch06.ch06_01;

import org.omg.CORBA.BAD_QOS;

public class Test3 {

    double price(){
        //price is base price - quantity discount + shipping
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double price(){
        //price is base price - quantity discount + shipping
        final double basePrice = _quantity * _itemPrice;
        return basePrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double price(){
        //price is base price - quantity discount + shipping
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        return basePrice - quantityDiscount +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double price(){
        //price is base price - quantity discount + shipping
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        final double shipping  = Math.min(_quantity * _itemPrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;

    }

    //回到起始
    //     ||
    //     ||
    //    \||/
    //     \/

    double price(){
        //price is base price - quantity discount + shipping
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }

    //不使用变量，使用方法处理
    //     ||
    //     ||
    //    \||/
    //     \/

    double price(){
        //price is base price - quantity discount + shipping
        return basePrice() - quantityDisCount() + shipping();
    }

    private double basePrice(){
        return _quantity * _itemPrice;
    }

    private double quantityDisCount(){
        return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    }

    private double shipping(){
        return Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }
}