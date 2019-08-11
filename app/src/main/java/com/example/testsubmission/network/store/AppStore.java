package com.example.testsubmission.network.store;

import android.util.Log;

import com.example.testsubmission.network.api.ServiceAPI;
import com.example.testsubmission.network.base.APIClient;
import com.example.testsubmission.network.base.IOnConnectionTimeoutListener;
import com.example.testsubmission.network.handlers.RestaurantRH;
import com.example.testsubmission.network.handlers.WeatherRH;
import com.example.testsubmission.network.handlers.callbacks.RestaurantUpdateCallback;
import com.example.testsubmission.network.handlers.callbacks.WeatherUpdateCallback;
import com.example.testsubmission.network.models.request.WeatherRequest;
import com.google.android.gms.maps.model.LatLng;


public class AppStore implements IOnConnectionTimeoutListener {

    private static AppStore appStore;

    ServiceAPI serviceAPI = APIClient.getClient(this).create(ServiceAPI.class);;

    private AppStore(){}

    public static AppStore getInstance(){
        if (appStore == null)
            return new AppStore();
        else
            return appStore;
    }

//    public void getWeatherUpdates(String keys, LatLng latLng,int days, WeatherUpdateCallback weatherUpdateCallback){
//        serviceAPI.getWeatherUpdate(keys,latLng,days).enqueue(new WeatherRH(weatherUpdateCallback));
//    }
    public void getWeatherUpdates(String url, WeatherUpdateCallback weatherUpdateCallback){
        serviceAPI.getWeatherUpdate(url).enqueue(new WeatherRH(weatherUpdateCallback));
    }

    public void getRestaurantUpdates(String url,  RestaurantUpdateCallback restaurantUpdateCallback){
        serviceAPI.getRestaurantResponse(url).enqueue(new RestaurantRH(restaurantUpdateCallback));
    }



    @Override
    public void onConnectionTimeout() {
        Log.d("time out", "request");
    }
}
