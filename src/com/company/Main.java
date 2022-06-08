package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    static Suche currentSuche;

    public static void main(String[] args) {
        // Nur fuer Testzwecke
        Auto auto = new Auto(new String[]{});
        Kosten kosten = new Kosten(auto, 10, 10);
        System.out.println(kosten.getGesamtkosten());
        QueueWithPointer<Double> einzelkosten = kosten.getEinzelkosten();
        for (int i = 0; i < 4; i++){
            System.out.println(einzelkosten.getPointer().getContent());
            einzelkosten.movePointerBack();
        }
        System.out.println(einzelkosten.getPointer().getContent());
        einzelkosten.movePointerBack();
        System.out.println(einzelkosten.getPointer().getContent());
        search();
        System.out.println(currentSuche.getKosten().getGesamtkosten());
        System.out.println(Arrays.toString(AutoList.list.get(0)));
        System.out.println(Arrays.toString(AutoList.list.get(0)));
        for (int i = 0; i < 9; i++) System.out.println(currentSuche.getAuto().getArray()[i]);
        ArrayList<String[]> list = AutoList.list;
        String b;
        int c = 1;
        String a = list.get(0)[1];
        // TODO Die Daten sind nicht ganz aufsteigend geordnet

        /*while (true) {
            b = list.get(c)[1];
            System.out.println(c);
            if (a.toLowerCase().compareTo(b.toLowerCase()) > 0) break;
            a = b;
            c++;
        }
        */
        ArrayList<String> test = AutoList.distinct(AutoList.list, 1);
        for (String e : test) System.out.println(e);
    }

    public static void search() {
        currentSuche = new Suche(new String[]{"a", "b"}, 2032, 10000); // Testsuche
    }

    // Eingabedaten: Autodaten, Kilometer im Jahr, Kosten bis Jahr



}
