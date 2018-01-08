package com.vivi.ch06.ch06_01;

import sun.security.util.AuthResources_de;

public class Test4 {

    double getDistanceTravelled(int time){
        double result;
        double acc = _primaryForce / _mass;
        int primaryTime = Math.min(time,_delay);
        result = 0.5 * acc * primaryTime * _delay;
        int secondaryTime = time - _delay;
        if(secondaryTime > 0){
            double primaryVel = acc * _delay;
            acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime
                    * secondaryTime;
        }
        return result;
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double getDistanceTravelled2(int time){
        double result;
        final double _primaryAcc = _primaryForce / _mass;
        int primaryTime = Math.min(time,_delay);
        result = 0.5 * _primaryAcc * primaryTime * _delay;
        int secondaryTime = time - _delay;
        if(secondaryTime > 0){
            double primaryVel = _primaryAcc * _delay;
            double acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime
                    * secondaryTime;
        }
        return result;
    }

    //     ||
    //     ||
    //    \||/
    //     \/

    double getDistanceTravelled3(int time){
        double result;
        final double _primaryAcc = _primaryForce / _mass;
        int primaryTime = Math.min(time,_delay);
        result = 0.5 * _primaryAcc * primaryTime * _delay;
        int secondaryTime = time - _delay;
        if(secondaryTime > 0){
            double primaryVel = _primaryAcc * _delay;
            final double _secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * _secondaryAcc * secondaryTime
                    * secondaryTime;
        }
        return result;
    }
}