package com.example.testsubmission.network.models.weatherresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponseError {

@SerializedName("error")
@Expose
public Error error;

}