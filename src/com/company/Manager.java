package com.company;

public class Manager {

    static Suche currentSuche;

    public static void main(String[] args) {
        // Test
        Auto auto = new Auto(100);
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
    }

    public static void search() {
        currentSuche = new Suche(new String[]{"a", "b"}, 2032, 10000); // Testsuche
    }

    // Eingabedaten: Autodaten, Kilometer im Jahr, Kosten bis Jahr



}
