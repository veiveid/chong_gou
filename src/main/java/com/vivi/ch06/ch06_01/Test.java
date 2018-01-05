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

}