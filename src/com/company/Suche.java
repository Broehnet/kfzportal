package com.company;

public class Suche {

    private final Auto auto;
    private final Kosten kosten;
    private final int kmProJahr;
    private final int zeitEnde;
    // Graphdaten muessen hier noch eingefuegt werden

    Suche(String[] eingabe, int zeitEnde, int kmProJahr) {
        this.auto = FileManager.getAutoFromInput(eingabe);
        this.zeitEnde = zeitEnde;
        this.kmProJahr = kmProJahr;
        this.kosten = new Kosten(auto, zeitEnde - Constants.JAHR, kmProJahr);
    }

    public Auto getAuto() {
        return auto;
    }

    public Kosten getKosten() {
        return kosten;
    }

    public int getKmProJahr() {
        return kmProJahr;
    }

    public int getZeitEnde() {
        return zeitEnde;
    }

}
