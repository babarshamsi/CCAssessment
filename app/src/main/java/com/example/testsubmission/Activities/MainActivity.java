package com.example.testsubmission.Activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.example.testsubmission.R;
import com.example.testsubmission.location.GeoAPIClientLayer;
import com.example.testsubmission.managers.SharedPreferenceManager;
import com.google.android.gms.maps.model.LatLng;

import java.security.Permissions;
import java.util.ArrayList;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

public class MainActivity extends BaseActivity implements View.OnClickListener, com.google.android.gms.location.LocationListener {

    private GeoAPIClientLayer mGoogleApiClientLayer;
    private LatLng latLng;

    final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
    private boolean permissionToAccessLocationAccepted = false;
    private String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION
            , Manifest.permission.ACCESS_FINE_LOCATION};

    private static final int REQUEST_LOCATION_PERMISSION = 100;
    private static final int REQUEST_LOCATION_SETTINGS = 1;


    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        checkIsLocationEnabled();
        setPreviousLatLng();
        getSupportActionBar().setTitle("Assessment");
        attachClickListener(R.id.bt_restaurant_info, R.id.bt_weather_info);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOCATION_SETTINGS:
                checkIsLocationEnabled();
        }

    }

    private void showLatLng(Location location) {
//        showToast(String.valueOf(location.getLatitude()));
//        showToast(String.valueOf(location.getLongitude()));
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
            showAlertMessageForEnableLocation(this,getString(R.string.enable_location), getString(R.string.enable_location_message), getString(R.string.open_settings), getString(R.string.later), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i){
                        case BUTTON_POSITIVE:
                            startActivityForResult(new Intent(action),1);
                            dialogInterface.dismiss();
                            break;
                        case BUTTON_NEGATIVE:
                            onBackPressed();
                            break;
                    }

                }
            });
        else
            ActivityCompat.requestPermissions(this, permissions, REQUEST_LOCATION_PERMISSION);

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
//        showLatLng(location);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                permissionToAccessLocationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED;
                mGoogleApiClientLayer = new GeoAPIClientLayer(this);

                break;
        }
        if (!permissionToAccessLocationAccepted) finish();
    }

}
