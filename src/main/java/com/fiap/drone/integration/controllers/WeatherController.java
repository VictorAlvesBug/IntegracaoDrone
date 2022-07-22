package com.fiap.drone.integration.controllers;

import com.fiap.drone.integration.models.Satelite;
import com.fiap.drone.integration.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("satelite")
public class WeatherController {
    private double lat,lon;

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Satelite> verificarSatelite(){
        Satelite satelite = weatherService.searchWeather();
        return ResponseEntity.ok().body(satelite);
    }
}
