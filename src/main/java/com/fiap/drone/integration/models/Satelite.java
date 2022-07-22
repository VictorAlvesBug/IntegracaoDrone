package com.fiap.drone.integration.models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Satelite {

        public Coord coord;
        public ArrayList<Weather> weather;
        public String base;
        public WeatherInfos main;
        public int visibility;
        public Wind wind;
        public Clouds clouds;
        public int dt;
        public Sys sys;
        public int timezone;
        public int id;
        public String name;
        public int cod;

}
