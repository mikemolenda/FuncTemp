package com.mikemolenda.functemp;

public class CityWeather {

    private String name;
    private double latitude;
    private double longitude;
    private int[] avgHighTemps;

    public CityWeather(String name, double latitude, double longitude, int[] avgHighTemps) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avgHighTemps = avgHighTemps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int[] getAvgHighTemps() {
        return avgHighTemps;
    }

    public void setAvgHighTemps(int[] avgHighTemps) {
        this.avgHighTemps = avgHighTemps;
    }

}
