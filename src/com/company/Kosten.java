package com.company;

public class Kosten {

    private final int currentJahr = Constants.JAHR;
    private Auto auto;
    private int jahre;
    private Queue einzelkosten;
    private Double gesamtkosten;
    private int kmProJahr;

    Kosten(Auto auto, int zeitraum) {
        this.auto = auto;
        this.jahre = zeitraum - currentJahr;
    }

    public Queue getEinzelkosten() {
        return einzelkosten;
    }

    public Double getGesamtkosten() {
        return gesamtkosten;
    }

    public double sprit() {
        return kmProJahr * (auto.getVerbrauch() / 100) * jahre;
    }

    public double verbrauchKosten() {
        return sprit() * Constants.getPrice(auto.getKraftstoff());
    }

    public double steuern() {

    }

    public double versicherung() {

    }

    public double verschleiss() {

    }

    public double tuev() {

    }

    public void gesamt() {

    }

}
