package com.example.testsubmission.network.store;

import android.util.Log;

import com.example.testsubmission.network.api.ServiceAPI;
import com.example.testsubmission.network.base.APIClient;
import com.example.testsubmission.network.base.IOnConnectionTimeoutListener;


public class AppStore implements IOnConnectionTimeoutListener {

    private static AppStore appStore;

    ServiceAPI consumerAPI = APIClient.getClient(this).create(ServiceAPI.class);;

    private AppStore(){}

    public static AppStore getInstance(){
        if (appStore == null)
            return new AppStore();
        else
            return appStore;
    }




    @Override
    public void onConnectionTimeout() {
        Log.d("time out", "request");
    }
}
