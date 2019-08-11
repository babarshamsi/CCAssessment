package com.example.testsubmission.network.models.restaurantResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantResponse {

@SerializedName("next_page_token")
@Expose
public String nextPageToken;
@SerializedName("results")
@Expose
public List<Result> results = null;
@SerializedName("status")
@Expose
public String status;

}