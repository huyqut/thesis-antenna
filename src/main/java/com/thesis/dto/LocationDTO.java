package com.thesis.dto;

import com.google.maps.model.Geometry;

import java.util.List;

/**
 * Created by lap08 on 5/16/2017.
 */
public class LocationDTO {

    private String place;
    private Integer count;
    private Geometry geometry;
    private List<NewsDTO> newsDTOList;

    public LocationDTO(String place, Integer count, Geometry geometry, List<NewsDTO> newsDTOList) {
        this.place = place;
        this.count = count;
        this.geometry = geometry;
        this.newsDTOList = newsDTOList;
    }

    public List<NewsDTO> getNewsDTOList() {
        return newsDTOList;
    }

    public LocationDTO setNewsDTOList(List<NewsDTO> newsDTOList) {
        this.newsDTOList = newsDTOList;
        return this;
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
