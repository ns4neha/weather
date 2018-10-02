package com.neha.weather_test.response;

import lombok.Builder;
import lombok.Getter;

@Builder

public class SysResponse {

    private String country;
    private Integer sunrise;
    private Integer sunset;

    public String getCountry() {
        return country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }
}
