package com.example.testsubmission.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;

import com.example.testsubmission.R;
import com.example.testsubmission.location.GeoAPIClientLayer;
import com.example.testsubmission.managers.SharedPreferenceManager;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends BaseActivity implements View.OnClickListener, com.google.android.gms.location.LocationListener {

    private GeoAPIClientLayer mGoogleApiClientLayer;
    private LatLng latLng;


    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        checkIsLocationEnabled();
        setPreviousLatLng();
        attachClickListener(R.id.bt_restaurant_info, R.id.bt_weather_info);
        mGoogleApiClientLayer = new GeoAPIClientLayer(this);

    }

    private void showLatLng(Location location) {
        showToast(String.valueOf(location.getLatitude()));
        showToast(String.valueOf(location.getLongitude()));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    private void setPreviousLatLng() {
        latLng = new LatLng(SharedPreferenceManager.getInstance(this).getLatitude(), SharedPreferenceManager.getInstance(this).getLongitude());
    }


    public void checkIsLocationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!gps_enabled && !network_enabled)
            showAlertMessageForEnableLocation(this, "Please Enabled your Location", "", "Open Settings", "Later", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onBackPressed();
                }
            });
        else
            mGoogleApiClientLayer = new GeoAPIClientLayer(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_restaurant_info:
                gotoActivity(NearestRestaurantActivity.class);
                break;

            case R.id.bt_weather_info:
                gotoActivity(WeatherUpdateActivity.class);

                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        SharedPreferenceManager.getInstance(this).setLatitude(location.getLatitude());
        SharedPreferenceManager.getInstance(this).setLongitude(location.getLongitude());
        showLatLng(location);
    }
}
