package com.poc.incometax.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class EmployeeDetailsResponse {

    private Integer statusCode;
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public EmployeeDetailsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return  this;
    }

    public String getMessage() {
        return message;
    }

    public EmployeeDetailsResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
