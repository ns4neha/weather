package com.neha.weather_test.client;

import com.neha.weather_test.model.WeatherData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="weather-demo.client", url="https://api.openweathermap.org/data/2.5")
public interface WeatherClient {

    @RequestMapping(method = RequestMethod.GET, value = "/weather?q={city}&APPID=${openweatherapi.appId}")
    WeatherData getCity(@RequestParam("city") String city);

}
