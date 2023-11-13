package com.example.weather.controller;

import com.example.weather.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${openweathermap.api.key}")
    private String key;
    @GetMapping("/lat={lat}&lon={lon}")
    public ResponseEntity<Weather> getWeather(@PathVariable Double lat, @PathVariable Double lon){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + key;
        ResponseEntity<Weather> response = restTemplate.getForEntity(uri, Weather.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            // Вернуть объект Weather в случае успешного запроса
            Weather weather = response.getBody();

            // Преобразовать температуру в градусы Цельсия
            if (weather != null && weather.getMain() != null) {
                weather.getMain().convertToCelsius();
            }

            return ResponseEntity.ok(weather);
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
