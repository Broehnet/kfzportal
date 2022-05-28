package com.company;

public class Kosten {

    private final Auto auto;
    private final int jahre;
    private final QueueWithPointer<Double> einzelkosten;
    private final double gesamtkosten;
    private final int kmProJahr;

    Kosten(Auto auto, int jahre, int kmProJahr) {
        this.auto = auto;
        this.jahre = jahre;
        this.einzelkosten = new QueueWithPointer<>();
        this.kmProJahr = kmProJahr;
        buildEinzelkosten();
        gesamtkosten = sumEinzelkosten();
    }

    private void buildEinzelkosten() {
        einzelkosten.enqueue(new Element<>(null, verbrauchKosten()));
        einzelkosten.enqueue(new Element<>(null, steuern()));
        einzelkosten.enqueue(new Element<>(null, versicherung()));
        einzelkosten.enqueue(new Element<>(null, verschleiss()));
        einzelkosten.enqueue(new Element<>(null, tuev()));
    }

    private double sumEinzelkosten() {
        double sum = 0;
        for (int i = 0; i < 5; i++) {
           sum += einzelkosten.getPointer().getContent();
           einzelkosten.movePointerBack();
        }
        return sum;
    }

    public QueueWithPointer<Double> getEinzelkosten() {
        return einzelkosten;
    }

    public double getGesamtkosten() {
        return gesamtkosten;
    }

    public double sprit() {
        return kmProJahr * (auto.getVerbrauch() / 100) * jahre;
    }

    public double verbrauchKosten() {
        return sprit() * Constants.getPrice(auto.getKraftstoff());
    }

    public double steuern() {
        return 1.0;
    }

    public double versicherung() {
        return 1.0;
    }

    public double verschleiss() {
        return 1.0;
    }

    public double tuev() {
        return 1.0;
    }

    public void gesamt() {
    }

}
