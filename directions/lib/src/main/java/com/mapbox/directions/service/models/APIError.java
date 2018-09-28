package com.mapbox.directions.service.models;

import java.util.ArrayList;
import java.util.List;

public class APIError {

    private String code;
    private String message;

    public APIError() {

    }



    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
