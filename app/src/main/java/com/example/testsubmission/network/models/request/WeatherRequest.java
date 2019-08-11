package com.example.testsubmission.network.models.request;

import com.google.android.gms.maps.model.LatLng;

public class WeatherRequest {

    int days;
    LatLng latlng;
    String key;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
