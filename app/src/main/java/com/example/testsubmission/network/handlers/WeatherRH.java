package com.example.testsubmission.network.handlers;

import com.example.testsubmission.network.handlers.callbacks.WeatherUpdateCallback;
import com.example.testsubmission.network.models.weatherresponse.WeatherForcastResponse;
import com.example.testsubmission.network.models.weatherresponse.WeatherResponseError;

import retrofit2.Response;

public class WeatherRH extends BaseRH<WeatherForcastResponse> {

    WeatherUpdateCallback weatherUpdateCallback;

    public WeatherRH(WeatherUpdateCallback weatherUpdateCallback) {
        this.weatherUpdateCallback = weatherUpdateCallback;
    }

    @Override
    protected void onSuccess(Response<WeatherForcastResponse> response) {
        weatherUpdateCallback.onWeatherUpdateSuccess(response.body());
    }

    @Override
    protected void onFailure(Class<?> response) {
        int i =0;
//weatherUpdateCallback.onWeatherUpdateFailure(response);
    }
}
