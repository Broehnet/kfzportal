package com.company;

public class Auto {
    public double verbrauch;
    public String kraftstoff;
    // Test
    Auto(double verbrauch) {
       this.kraftstoff = "a";
       this.verbrauch = verbrauch;
    }

    public double getVerbrauch() {
        return this.verbrauch;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }
}
