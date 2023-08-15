package com.example.jwt.demo.response;


import org.springframework.http.HttpStatus;


public class FresherResponse {
    private String Message;
    private HttpStatus status;
    private Object DATA;

    public FresherResponse(String message, Object DATA, HttpStatus status) {
        this.status = status;
        this.Message = message;
        this.DATA=DATA;
    }

    public Object getDATA() {
        return DATA;
    }

    public void setDATA(Object DATA) {
        this.DATA = DATA;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
