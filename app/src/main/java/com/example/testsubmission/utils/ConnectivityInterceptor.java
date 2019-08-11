package com.example.testsubmission.utils;

import android.content.Context;

import com.example.testsubmission.Activities.BaseActivity;
import com.example.testsubmission.R;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.testsubmission.utils.NetworkUtil.isConnectedToNet;


public class ConnectivityInterceptor implements Interceptor {

    private Context mContext;

    public ConnectivityInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isConnectedToNet(mContext)) {
            throw new NoInternetConnectivityException();

        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

}