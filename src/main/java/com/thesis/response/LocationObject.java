package com.thesis.response;

import com.google.maps.model.Geometry;

/**
 * Created by lap08 on 5/16/2017.
 */
public class LocationObject {

    private String place;
    private Integer count;
    private Geometry geometry;

    public LocationObject(String place, Integer count, Geometry geometry) {
        this.place = place;
        this.count = count;
        this.geometry = geometry;
    }

    public String getPlace() {
        return place;
    }

    public LocationObject setPlace(String place) {
        this.place = place;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public LocationObject setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public LocationObject setGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }
}
