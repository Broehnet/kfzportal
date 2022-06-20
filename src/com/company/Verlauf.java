package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Verlauf {

    private int dauer;
    private int kmProJahr;
    private Auto auto;

    Verlauf(String[] line) {
        this.dauer = Integer.parseInt(line[0]);
        this.kmProJahr = Integer.parseInt(line[1]);
        ArrayList<String> forAuto = new ArrayList<>(Arrays.asList(line));
        forAuto.subList(0, 2).clear();
        this.auto = new Auto(forAuto.toArray(new String[0]));
    }


}
