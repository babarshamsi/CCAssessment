package com.example.testsubmission.network.models.restaurantResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {


@SerializedName("icon")
@Expose
public String icon;
@SerializedName("id")
@Expose
public String id;
@SerializedName("name")
@Expose
public String name;
@SerializedName("place_id")
@Expose
public String placeId;
@SerializedName("price_level")
@Expose
public Integer priceLevel;
@SerializedName("rating")
@Expose
public Double rating;
@SerializedName("reference")
@Expose
public String reference;
@SerializedName("scope")
@Expose
public String scope;
@SerializedName("types")
@Expose
public List<String> types = null;
@SerializedName("user_ratings_total")
@Expose
public Integer userRatingsTotal;
@SerializedName("vicinity")
@Expose
public String vicinity;

}