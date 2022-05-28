package com.company;

public class Manager {

    public static void main(String[] args) {
        // Test
        Auto auto = new Auto(100);
        Kosten kosten = new Kosten(auto, 2030, 10);
        System.out.println(kosten.getGesamtkosten());
        QueueWithPointer<Double> einzelkosten = kosten.getEinzelkosten();
        for (int i = 0; i < 4; i++){
            System.out.println(einzelkosten.getPointer().getContent());
            einzelkosten.movePointerBack();
        }
        System.out.println(einzelkosten.getPointer().getContent());
        einzelkosten.movePointerBack();
        System.out.println(einzelkosten.getPointer().getContent());
    }

}
