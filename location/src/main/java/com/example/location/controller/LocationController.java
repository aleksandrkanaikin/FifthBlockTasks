package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.repository.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private GeodataRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/weather")
    public Weather redirectRequestWeather(@RequestParam String location) {
        Geodata geodata = repository.findByName(location).get();
        String url = String.format("http://localhost:8082/weather/lat=%s&lon=%s", geodata.getLat(), geodata.getLon());
        return restTemplate.getForObject(url, Weather.class);
    }

    @GetMapping
    public Optional<Geodata> getWeather(@RequestParam String location) {
        return repository.findByName(location);
    }

    @PostMapping
    public Geodata save(@RequestBody Geodata geodata) {
        return repository.save(geodata);
    }
}
