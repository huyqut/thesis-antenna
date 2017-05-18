package com.thesis.response;

public class Response<Data> {
    private Integer status;
    private String message;
    private Data data;

    public Response(Integer status, String message, Data data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }
}
