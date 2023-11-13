package com.example.weather.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
public class Weather {
    private String name; // Имя города
    private List<WeatherItem> weather; // Группа параметров погоды
    private Main main; // Основные параметры погоды

    @Data
    public static class WeatherItem {
        private String main; // Группа погоды (например, "Clouds", "Rain", "Snow" и т. д.)
        private String description; // Описание погоды
    }

    @Data
    @Accessors(chain = true)
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;


        public Main convertToCelsius() {
            this.temp = this.temp - 273.15;
            this.feels_like = this.feels_like - 273.15;
            this.temp_min = this.temp_min - 273.15;
            this.temp_max = this.temp_max - 273.15;
            return this;
        }
    }
}
