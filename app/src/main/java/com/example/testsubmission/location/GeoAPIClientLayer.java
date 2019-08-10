package com.example.testsubmission.location;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.testsubmission.Activities.MainActivity;
import com.example.testsubmission.utils.PermissionsUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class GeoAPIClientLayer implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    MainActivity mActivity;

    public GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

    public synchronized void    buildGoogleApiClient(Activity mActivity) {
        mGoogleApiClient = new GoogleApiClient.Builder(mActivity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }




    public GeoAPIClientLayer(MainActivity mActivity) {
        this.mActivity = mActivity;
        buildGoogleApiClient(mActivity);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        //ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        if (PermissionsUtil.checkLocationPermission(mActivity)) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationRequest, mActivity);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

//    public void stopLocationUpdates(){
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, mActivity);
//    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

}