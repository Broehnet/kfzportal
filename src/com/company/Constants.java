package com.company;

import java.util.Locale;

public class Constants {

    static final double BENZIN = 1.92;
    static final double DIESEL = 2.00;
    static final int JAHR = 2022;

    public static double getPrice(String kraftstoff) {
        if (kraftstoff.toLowerCase().equals("diesel")) return DIESEL;
        else return BENZIN;
    }
}
