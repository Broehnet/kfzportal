package com.company;

public class Constants {

    static final double SUPER = 2.10;
    static final double SUPERE10 = 2.05;
    static final double DIESEL = 2.00;
    static final int JAHR = 2020;

    public static double getPrice(String kraftstoff) {
        switch (kraftstoff){
            case "a":
                return SUPER;
            case "b":
                return SUPERE10;
            case "c":
                return DIESEL;
            default:
                return -1;
        }

    }
}
