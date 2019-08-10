package com.example.testsubmission.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by omamamoin on 11/17/16.
 */
public class NetworkUtil {

    public static boolean isConnectedToNet(Context _context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
