package com.thesis.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <h1> Error Code </h1>
 *
 * The static response error code
 */
public enum ErrorCode {


    ;

    private int statusCode;

    private ErrorCode(int errorCode) {
        this.statusCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return statusCode;
    }
}
