package com.example.testsubmission.network.models.weatherresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

@SerializedName("code")
@Expose
public Integer code;
@SerializedName("message")
@Expose
public String message;

}