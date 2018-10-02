package com.neha.weather_test.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data

public class WeatherResponse {

    private String description ;
}
