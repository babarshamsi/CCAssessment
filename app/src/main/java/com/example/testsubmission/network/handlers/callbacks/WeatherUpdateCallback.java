package com.example.testsubmission.network.handlers.callbacks;

import com.example.testsubmission.network.models.weatherresponse.WeatherForcastResponse;
import com.example.testsubmission.network.models.weatherresponse.WeatherResponseError;

public interface WeatherUpdateCallback {
    void onWeatherUpdateSuccess(WeatherForcastResponse weatherForcastResponse);
//    void onWeatherUpdateFailure(Void baseResponse);
}