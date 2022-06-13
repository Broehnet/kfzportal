package com.company;

public class Auto {
    final private String marke;
    final private String model;
    final private String trim;
    final private String cylinder_layout;
    final private int numberOfCylinders;
    final private String engine_type;
    final private double mixed_fuel;
    final private double city_fuel;
    final private double highway_fuel;
    final private double hubraum;

    Auto(String[] arr) {
       this.marke = arr[0];
       this.model = arr[1];
       this.trim = arr[2];
       this.cylinder_layout = arr[3];
       this.numberOfCylinders = Integer.parseInt(arr[4]);
       this.engine_type = arr[5];
       this.mixed_fuel = Double.parseDouble(arr[6]);
       this.city_fuel = Double.parseDouble(arr[7]);
       this.highway_fuel = Double.parseDouble(arr[8]);
       this.hubraum = initHubraum();
    }

    private double initHubraum() {
        return Double.parseDouble(trim.substring(0, 3));
    }

    public String getMarke() {
        return marke;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public String getCylinder_layout() {
        return cylinder_layout;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public double getMixed_fuel() {
        return mixed_fuel;
    }

    public double getCity_fuel() {
        return city_fuel;
    }

    public double getHighway_fuel() {
        return highway_fuel;
    }

    public double getHubraum() {
        return hubraum;
    }
}
