package com.thesis.response;

/**
 * Created by huyqut on 5/18/17.
 */
public enum Success {
    TOP_LOCATION_FOUND(1, "Top locations are found"),
    GET_DATA_GRAPH(1, "Get data graph success"),
    LOAD_WEB(2, "Web is fully loaded");

    private int status;
    private String message;

    private Success(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public <D> Response<D> with(D data) {
        return new Response<>(this.status, this.message, data);
    }
}
