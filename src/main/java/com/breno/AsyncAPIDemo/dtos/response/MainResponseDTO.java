package com.breno.AsyncAPIDemo.dtos.response;

import org.springframework.http.HttpStatus;

public class MainResponseDTO {

    private String message;

    private HttpStatus status;

    private MainResponseDataDTO data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public MainResponseDataDTO getData() {
        return data;
    }

    public void setData(MainResponseDataDTO data) {
        this.data = data;
    }
}
