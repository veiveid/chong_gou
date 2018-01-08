package com.vivi.ch06.ch06_01;

public class Test {

    /**    tag1
    int getRating(){
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }*/

    boolean moreThanFiveLateDeliveries(){
        return _numberOfLateDeliveries > 5;
    }

    //tag1的代码可以修改为：
    int getRating(){
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }


    /**将所有对该变量的引用动作，替换为对他赋值的那个表达式自身 tag2
    double basePrice = anOrder.basePrice();
    return (basePrice > 1000);
    */

    //tag2代码可以修改为：
    return anOrder.basePrice() > 1000;

    /**
     * tag3
     * 将这个表达式提炼到一个独立函数中，将这个临时变量的所有引用点替换为对函数的调用，此后，新函数就可以被其他函数调用

    double basePrice  = _quantity * _itemPrice;
    if(basePrice > 1000)
        return basePrice * 0.95;
    else
        return basePrice * 0.98;
    */

    //tag3可以修改为：
    if(basePrice()>1000)
         return basePrice * 0.95;
    else
         return basePrice * 0.98;

    double basePrice(){
        return _quantity * _itemPrice;
    }

}