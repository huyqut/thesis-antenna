package com.thesis.response;

/**
 * Created by huyqut on 5/18/17.
 */
public enum Failure {
    ;

    private int status;
    private String message;

    private Failure(int status, String message) {
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
