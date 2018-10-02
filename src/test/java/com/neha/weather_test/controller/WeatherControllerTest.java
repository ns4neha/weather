package com.neha.weather_test.controller;

import com.neha.weather_test.client.WeatherClient;
import com.neha.weather_test.model.Weather;
import com.neha.weather_test.model.WeatherData;
import com.neha.weather_test.response.WeatherDataResponse;
import com.neha.weather_test.response.WeatherResponse;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
                .build() ;
        when(weatherClient.getCity(city)).thenReturn(weatherData);

        //When
        WeatherDataResponse weatherDataResponse = weatherController.
                getWeatherDetails(weatherSearch);

        //Then
        verify(weatherClient).getCity(city);
        assertEquals("London", weatherDataResponse.getName());
        assertEquals(new Date(1538414400), weatherDataResponse.getDate());

    }

}
