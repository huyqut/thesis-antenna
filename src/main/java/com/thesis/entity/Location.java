package com.thesis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "location-collection")
public class Location {
    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("place")
    private String place;

    @JsonProperty("count")
    private Integer count;

    public String get_Id() {
        return _id;
    }

    public Location set_Id(String id) {
        this._id = id;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Location setPlace(String place) {
        this.place = place;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Location setCount(Integer count) {
        this.count = count;
        return this;
    }
}