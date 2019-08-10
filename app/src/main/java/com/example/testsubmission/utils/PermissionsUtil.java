package com.example.testsubmission.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.testsubmission.Activities.BaseActivity;
import com.example.testsubmission.R;

import java.util.ArrayList;
import java.util.List;

public class PermissionsUtil {


    public static final int PERMISSIONS_REQUEST_LOCATION = 100;


    public static boolean checkAndRequestPermissions(Activity mActivity, String[] permissionList, final int requestCode) {

        List<String> listPermissionsNeeded = new ArrayList<>();

        for (String permission : permissionList){

            int hasPermission = ContextCompat.checkSelfPermission(mActivity,permission);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {

                listPermissionsNeeded.add(permission);
            }
        }

        // Request Permissions

        if (!listPermissionsNeeded.isEmpty()) {

            ActivityCompat.requestPermissions(mActivity,listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),requestCode);
            return false;
        }

        return true;
    }

    public static boolean checkLocationPermissionBelowM(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    public static boolean _isAppHasAllRequiredPermission(Activity activity) {

        LocationManager locationManager = (LocationManager) activity.getSystemService( Context.LOCATION_SERVICE );


        if(locationManager != null && !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && !NetworkUtil.isConnectedToNet(activity)) {

            DialogUtil.showAlertMessageForLocationsAndInternet(activity, activity.getString(R.string.enable_location), activity.getString(R.string.gps_not_enabled), activity.getString(R.string.next), activity.getString(R.string.internet_connection_title), activity.getString(R.string.no_internet_connection));

            return false;
        }

        else if(locationManager != null && !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            DialogUtil.showAlertMessage(activity,activity.getString(R.string.enable_location),activity.getString(R.string.gps_not_enabled), activity.getString(R.string.ok));

            return false;
        }
        else if(!NetworkUtil.isConnectedToNet(activity)) {
            DialogUtil.showAlertMessage(activity,activity.getString(R.string.internet_connection_title),activity.getString(R.string.no_internet_connection), activity.getString(R.string.ok));
            return false;
        }
//        else if(!_isWritePermissionEnabled()) {
//            return false;
//        }
        else {
            return true;
        }


    }



    public static boolean checkMultiplePermissions(Activity mActivity, List<String> permissions) {

        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkLocationPermission(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkCameraPermission(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }



}