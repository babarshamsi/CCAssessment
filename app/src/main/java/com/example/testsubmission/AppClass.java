package com.example.testsubmission;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.testsubmission.Activities.BaseActivity;
import com.google.android.gms.common.api.GoogleApiClient;

public class AppClass extends MultiDexApplication {

    private static AppClass appClass;
    private static BaseActivity currentActivity;
    private GoogleApiClient mGoogleApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
//        MultiDex.install(this);
        appClass = this;
    }


    public static AppClass getAppClass() {
        return appClass;
    }

    public static BaseActivity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(BaseActivity currentActivity) {
        AppClass.currentActivity = currentActivity;
    }

    public void setClient(GoogleApiClient client){
        mGoogleApiClient = client;
    }

    public GoogleApiClient getClient(){
        return mGoogleApiClient;
    }
}
