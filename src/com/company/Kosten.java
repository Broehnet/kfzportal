package com.company;

public class Kosten {

    private final String[] auto;
    private final int dauer;
    private final QueueWithPointer<Double> einzelkosten;
    private final double gesamtkosten;
    private final int kmProJahr;

    Kosten(String[] auto, int kmProJahr, int dauer) {
        this.auto = auto;
        this.dauer = dauer;
        this.kmProJahr = kmProJahr;
        this.einzelkosten = new QueueWithPointer<>();
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
    // TODO Berechnung

    public QueueWithPointer<Double> getEinzelkosten() {
        return einzelkosten;
    }

    public String[] getAuto() { return auto; }

    public double getGesamtkosten() {
        return gesamtkosten;
    }

    public double sprit() {
        return kmProJahr * dauer;
    }

    public double verbrauchKosten() {
        return sprit() * Constants.getPrice("a");
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

}
