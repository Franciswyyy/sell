package com.imooc.utils;

public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2){
        Double resule = Math.abs(d1 - d2);
        if(resule < MONEY_RANGE){
            return true;
        }else {
            return false;
        }
    }
}
