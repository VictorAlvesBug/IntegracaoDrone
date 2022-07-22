package com.fiap.drone.integration.services;

import com.fiap.drone.integration.models.Coord;
import com.fiap.drone.integration.models.Satelite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${wheather.api.key}")
    private String APIKEY;

    public Satelite searchWeather(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate=restTemplateBuilder.build();

        Satelite satelite = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat="+-23.54+"&lon="+-46.63+"&appid="+APIKEY+"", Satelite.class);

        System.out.println(satelite.main.celsius());
        System.out.println(satelite.main.temp);
        System.out.println(satelite.main.celsius());
        if(satelite.main.celsius() <= 10 || satelite.main.celsius() >= 45){
            System.out.println(satelite.main.celsius());
        }else if (satelite.main.humidity <= 10){
            //System.out.println(satelite.main.humidity);
        }

        return satelite;
    }
}
