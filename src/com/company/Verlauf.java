package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Verlauf {

    private int dauer;
    private int kmProJahr;
    private String[] auto;
    private double gesamtKosten;

    Verlauf(String[] line) {
        this.dauer = Integer.parseInt(line[0]);
        this.kmProJahr = Integer.parseInt(line[1]);
        this.gesamtKosten = Double.parseDouble(line[2]);
        ArrayList<String> forAuto = new ArrayList<>(Arrays.asList(line));
        forAuto.subList(0, 3).clear();
        this.auto = forAuto.toArray(new String[0]);
    }

    public int getDauer() {
        return dauer;
    }

    public int getKmProJahr() {
        return kmProJahr;
    }

    public String[] getAuto() {
        return auto;
    }

    public double getGesamtKosten() {
        return gesamtKosten;
    }
}
