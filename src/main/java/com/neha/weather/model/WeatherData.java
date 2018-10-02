
package com.neha.weather.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.neha.weather.response.WeatherDataResponse;
import com.neha.weather.response.WeatherResponse;
import com.neha.weather.response.SysResponse;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public WeatherDataResponse toResponse(){

        return WeatherDataResponse
                .builder()
                .date(new Date(this.dt))
                .name(this.name)
                .weatherResponse(WeatherResponse
                        .builder()
                        .description(this.getWeather().get(0).getDescription())
                        .build())
                .sysResponse(SysResponse.builder()
                        .country(sys.getCountry())
                        .sunrise(sys.getSunrise())
                        .sunset(sys.getSunset()).build())
                .build();

    }

}
