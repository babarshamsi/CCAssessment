package com.example.testsubmission.network.models.weatherresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

@SerializedName("forecastday")
@Expose
private List<Forecastday> forecastday = null;

public List<Forecastday> getForecastday() {
return forecastday;
}

public void setForecastday(List<Forecastday> forecastday) {
this.forecastday = forecastday;
}

}