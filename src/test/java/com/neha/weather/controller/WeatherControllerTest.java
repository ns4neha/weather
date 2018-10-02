package com.neha.weather.controller;

import com.neha.weather.client.WeatherClient;
import com.neha.weather.model.Sys;
import com.neha.weather.model.Weather;
import com.neha.weather.model.WeatherData;
import com.neha.weather.response.WeatherDataResponse;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WeatherControllerTest {

    @Mock
    GenericApplicationContext genericApplicationContext ;

    @Mock
    WeatherClient weatherClient ;

    @InjectMocks
    WeatherController weatherController ;

    @Test
    public void testWhenAValidCityNameIsPassedReturnsWeatherData(){

        //Given
        String city= "London" ;

        WeatherSearch weatherSearch = new WeatherSearch();
        weatherSearch.setCity(city);
        WeatherData weatherData = WeatherData.builder()
                .name("London")
                .dt(1538414400)
                .weather(Lists.newArrayList(
                        Weather.builder().description("Cloudy").build()))
                .sys(Sys.builder().country("GB").sunrise(1538414400).sunset(1538414400).build())
                .build() ;
        when(weatherClient.getCity(city)).thenReturn(weatherData);

        //When
        WeatherDataResponse weatherDataResponse = weatherController.
                getWeatherDetails(weatherSearch);

        //Then
        verify(weatherClient).getCity(city);
        assertEquals("London", weatherDataResponse.getName());
        assertEquals(new Date(1538414400), weatherDataResponse.getDate());
        assertEquals("Cloudy", weatherDataResponse.getWeatherResponse().getDescription());
        assertEquals("GB", weatherDataResponse.getSysResponse().getCountry());
        assertEquals(Instant.ofEpochSecond(1538414400).atOffset(ZoneOffset.UTC).toLocalTime()
                ,weatherDataResponse.getSysResponse().getSunrise());

    }

}
