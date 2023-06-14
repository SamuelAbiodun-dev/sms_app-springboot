package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {
    @NotBlank
    private final String phoneNUmber;
    @NotBlank
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNUmber,
                      @JsonProperty("message") String message){
        this.phoneNUmber = phoneNUmber;
        this.message = message;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNUmber='" + phoneNUmber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
