package com.thesis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by lap08 on 8/11/2017.
 */

@Document(collection = "news-collection")
public class News {
    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("title")
    private String title;

    @JsonProperty("people")
    @Field("people")
    private List<String> peopleList;

    @JsonProperty("places")
    @Field("places")
    private List<String> placeList;

    public String get_id() {
        return _id;
    }

    public News set_id(String _id) {
        this._id = _id;
        return this;
    }

    public List<String> getPlaceList() {
        return placeList;
    }

    public News setPlaceList(List<String> placeList) {
        this.placeList = placeList;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public News setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public News setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public News setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<String> getPeopleList() {
        return peopleList;
    }

    public News setPeopleList(List<String> people) {
        this.peopleList = people;
        return this;
    }
}