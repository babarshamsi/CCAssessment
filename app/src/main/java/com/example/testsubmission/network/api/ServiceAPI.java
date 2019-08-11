package com.example.testsubmission.network.api;


import com.example.testsubmission.network.models.restaurantResponse.RestaurantResponse;
import com.example.testsubmission.network.models.weatherresponse.WeatherForcastResponse;
import com.google.android.gms.maps.model.LatLng;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static com.example.testsubmission.keys.ApiKeys.WEATHER_API_KEYS;
import static com.example.testsubmission.network.api.EndPoints.WEATHER_URL;

public interface ServiceAPI {


//    @GET(WEATHER_URL)
//    Call<WeatherForcastResponse> getWeatherUpdate(@Query("key") String key,
//                                                  @Query("q") LatLng latLng,
//                                                  @Query("days") int days);
    @GET
    Call<WeatherForcastResponse> getWeatherUpdate(@Url String utl);

    @GET
    Call<RestaurantResponse> getRestaurantResponse(@Url String url);
}
