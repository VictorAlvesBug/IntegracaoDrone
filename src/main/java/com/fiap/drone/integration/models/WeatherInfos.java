package com.fiap.drone.integration.models;

public class WeatherInfos {
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;

    public double celsius(){
        Double tempC = temp-273.15;
        return tempC;
    }
}
