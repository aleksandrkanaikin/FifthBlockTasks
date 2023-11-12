package com.example.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    final String key = "449ace19e46aef7f8c5afef237f3c996";
    @GetMapping("/{lat}/{lon}")
    public ResponseEntity<String> getWeather(@PathVariable Double lat, @PathVariable Double lon){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + key;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return response;
    }
}
