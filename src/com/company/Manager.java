package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    static Kosten currentKosten;

    public static void search(int kmProJahr, int dauer, int index) {
        currentKosten = new Kosten(AutoList.currentListTrim.get(index), kmProJahr, dauer);
    }



}
