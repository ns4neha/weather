package com.neha.weather_test.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Data
public class WeatherDataResponse {
    private String name ;
    private Date date ;
    private WeatherResponse weatherResponse ;
    private SysResponse sysResponse ;
}
