package com.example.weatherapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/WeatherApi")
public class WeatherAppRestController {
    @Value("0")
    private int error;
    @Value("")
    private String errMessage;
    @Value("null")
    private Object data;

    public WeatherAppRestController(){

    }
    public WeatherAppRestController(Object data) {
        this.data = data;
    }
    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
