package com.thesis.common;

import com.fasterxml.jackson.annotation.JsonValue;


public enum SuccessCode {
    SUCCESS(200),
    ;

    private int statusCode;

    private SuccessCode(int statusCode) {
        this.statusCode= statusCode;
    }

    @JsonValue
    public int getSuccessCode() {
        return statusCode;
    }
}
