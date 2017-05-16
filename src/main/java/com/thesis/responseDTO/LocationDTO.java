package com.thesis.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.maps.model.Geometry;

/**
 * Created by lap08 on 5/16/2017.
 */
public class LocationDTO {

    private String place;
    private Integer count;
    private Geometry geometry;

    public LocationDTO(String place, Integer count, Geometry geometry) {
        this.place = place;
        this.count = count;
        this.geometry = geometry;
    }

    public String getPlace() {
        return place;
    }

    public LocationDTO setPlace(String place) {
        this.place = place;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public LocationDTO setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public LocationDTO setGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }
}
