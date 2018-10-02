package com.neha.weather_test.controller;

import com.neha.weather_test.client.WeatherClient;
import com.neha.weather_test.response.WeatherDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    @Autowired
    private WeatherClient weatherClient ;

    @PostMapping(value = "/weather", produces = "application/json")
    public WeatherDataResponse getWeatherDetails(@ModelAttribute WeatherSearch search){


        return weatherClient.getCity(search.getCity()).toResponse();
    }
}
