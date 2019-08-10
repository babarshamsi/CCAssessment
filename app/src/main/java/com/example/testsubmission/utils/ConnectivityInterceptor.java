package com.example.testsubmission.utils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.testsubmission.utils.NetworkUtil.isConnectedToNet;

/**
 * Created by subhan on 11/22/18.
 */


public class ConnectivityInterceptor implements Interceptor {

    private Context mContext;

    public ConnectivityInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (isConnectedToNet(mContext)) {
            throw new NoInternetConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

}