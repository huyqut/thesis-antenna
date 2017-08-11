package com.thesis.response;

import com.thesis.common.ErrorCode;
import com.thesis.common.SuccessCode;
import org.springframework.http.HttpStatus;

/**
 * <h1>Abstract Response Data Transfer Object</h1>
 *
 * This is the abstract class for response data transfer object
 * to integrate status code, status message and http response
 * status
 *
 */
public class AbstractResponse {

    private int statusCode;
    private String statusMessage;
    private int httpStatus;
    private Object responseObject;

    public AbstractResponse(Object responseObject, String message, SuccessCode successCode, ErrorCode errorCode) {
        this.statusMessage = message;
        if (errorCode == null) {
            this.statusCode = successCode.getSuccessCode();
        }
        else {
            this.statusCode = errorCode.getErrorCode();
        }
        this.responseObject = responseObject;
        this.httpStatus = HttpStatus.OK.value();
    }


    public Object getResponseObject() {
        return responseObject;
    }

    public AbstractResponse setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus.value();
    }
}