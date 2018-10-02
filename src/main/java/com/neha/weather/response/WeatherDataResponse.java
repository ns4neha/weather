package com.neha.weather.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class WeatherDataResponse {
    private String name ;
    private Date date ;
    private WeatherResponse weatherResponse ;
    private SysResponse sysResponse ;
}
