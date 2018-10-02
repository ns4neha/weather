package com.neha.weather.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;

@Builder

public class SysResponse {

    private String country;
    private Integer sunrise;
    private Integer sunset;

    public String getCountry() {
        return country;
    }

    public LocalTime getSunrise() {
        return Instant.ofEpochSecond(sunrise).atOffset(ZoneOffset.UTC).toLocalTime();
    }

    public LocalTime getSunset() {

        return Instant.ofEpochSecond(sunset).atOffset(ZoneOffset.UTC).toLocalTime();
    }
}
