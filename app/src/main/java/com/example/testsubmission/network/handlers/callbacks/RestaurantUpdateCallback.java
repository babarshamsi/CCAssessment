package com.example.testsubmission.network.handlers.callbacks;

import com.example.testsubmission.network.models.restaurantResponse.RestaurantResponse;
import com.example.testsubmission.network.models.weatherresponse.WeatherForcastResponse;

public interface RestaurantUpdateCallback {
    void onRestaurantUpdateSuccess(RestaurantResponse restaurantResponse);

}
