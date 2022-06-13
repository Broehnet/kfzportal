package com.company;

public class Kosten {

    private final Auto auto;
    private final int dauer;
    private final QueueWithPointer<Double> einzelkosten;
    private final double gesamtkosten;
    private final int kmProJahr;

    Kosten(String[] auto, int kmProJahr, int dauer) {
        this.auto = new Auto(auto);
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

    public Auto getAuto() { return auto; }
    public int getDauer() { return dauer; }

    public double getGesamtkosten() {
        return gesamtkosten;
    }

    public double sprit() {
        return (auto.getMixed_fuel() / 100) * kmProJahr * dauer; }

    public double verbrauchKosten() {
        return sprit() * Constants.getPrice(auto.getEngine_type());
    }

    public double steuern() {
        if (auto.getEngine_type().equalsIgnoreCase("diesel")) {
            double v = auto.getMixed_fuel() - 3.5 <= 0 ? 0 : auto.getMixed_fuel() - 3.5;
            return (95 * auto.getHubraum() + v * 54) * dauer;
        }
        else {
            double v = auto.getMixed_fuel() - 4.2 <= 0 ? 0 : auto.getMixed_fuel() - 4.2;
            return (20 * auto.getHubraum() + v * 45) * dauer;
        }
    }

    // Todo bisher nur Pauschale
    public double versicherung() {
        return 700 * dauer;
    }

    // Todo bisher nur Pauschale
    public double verschleiss() {
        return 300 * dauer;
    }

    public double tuev() {
        int anz = dauer - 4 <= 0 ? 0 : (int) Math.floor((dauer - 4) / 2);
        return 139 * anz;
    }

}
