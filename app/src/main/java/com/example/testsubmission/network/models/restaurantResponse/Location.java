package com.example.testsubmission.network.models.restaurantResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

@SerializedName("lat")
@Expose
public Double lat;
@SerializedName("lng")
@Expose
public Double lng;

}