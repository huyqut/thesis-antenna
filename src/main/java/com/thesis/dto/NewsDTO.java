package com.thesis.dto;

/**
 * Created by lap08 on 8/15/2017.
 */
public class NewsDTO {
    String title;
    String reference;
    String id;

    public NewsDTO(String title, String reference, String id) {
        this.title = title;
        this.reference = reference;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public NewsDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public NewsDTO setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getId() {
        return id;
    }

    public NewsDTO setId(String id) {
        this.id = id;
        return this;
    }
}
