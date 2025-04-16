package com.example.climaAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Clima(
        @JsonAlias("main") Main main,
        @JsonAlias("clouds") Clouds clouds,
        @JsonAlias("sys") Sys sys,
        @JsonAlias({"name", "city_name"}) String name
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Main(
            @JsonAlias("temp") double temp,
            @JsonAlias("feels_like") double feels_like,
            @JsonAlias("temp_min") double temp_min,
            @JsonAlias("temp_max") double temp_max,
            @JsonAlias("humidity") int humidity
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Clouds(
            @JsonAlias("all") int all
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Sys(
            @JsonAlias("country") String country
    ) {}

    @Override
    public String toString() {
        return "Cidade: " + name +
                "\nPaís: " + sys.country +
                "\nTemperatura: " + main.temp + "°C" +
                "\nSensação Térmica: " + main.feels_like + "°C" +
                "\nTemp Mín: " + main.temp_min + "°C" +
                "\nTemp Máx: " + main.temp_max + "°C" +
                "\nUmidade: " + main.humidity + "%" +
                "\nNuvens: " + clouds.all + "%";
    }
}
