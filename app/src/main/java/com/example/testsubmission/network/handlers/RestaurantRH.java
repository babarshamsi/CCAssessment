package com.example.testsubmission.network.handlers;

import com.example.testsubmission.network.handlers.callbacks.RestaurantUpdateCallback;
import com.example.testsubmission.network.models.restaurantResponse.RestaurantResponse;

import retrofit2.Response;

public class RestaurantRH extends BaseRH<RestaurantResponse> {

    RestaurantUpdateCallback restaurantUpdateCallback;

    public RestaurantRH(RestaurantUpdateCallback restaurantUpdateCallback) {
        this.restaurantUpdateCallback = restaurantUpdateCallback;
    }


    @Override
    protected void onSuccess(Response<RestaurantResponse> response) {
        restaurantUpdateCallback.onRestaurantUpdateSuccess(response.body());
    }

    @Override
    protected void onFailure(Class<?> response) {

    }
}
