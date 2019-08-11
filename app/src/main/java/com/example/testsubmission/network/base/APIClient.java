package com.example.testsubmission.network.base;


import com.example.testsubmission.AppClass;
import com.example.testsubmission.utils.ConnectivityInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.testsubmission.network.api.EndPoints.WEATHER_URL;

/**
 */
public class APIClient {

    private static Retrofit retrofit = null;
    private static Retrofit retrofitLongTimeout = null;
    private static IOnConnectionTimeoutListener timeoutListener;

    /**
     * @param listener
     * @return
     */
    public static Retrofit getClient(IOnConnectionTimeoutListener listener) {
        timeoutListener = listener;
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

            builder.readTimeout(APIConstants.READ_TIMEOUT, TimeUnit.SECONDS);
            builder.writeTimeout(APIConstants.WRITE_TIMEOUT, TimeUnit.SECONDS);
            builder.connectTimeout(APIConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
                if (AppClass.getAppClass() != null) {
                    builder.addInterceptor(new ChuckInterceptor(AppClass.getAppClass()));

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(interceptor);
            }
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    final Request original = chain.request();
                    final HttpUrl originalHttpUrl = original.url();

                    final HttpUrl url = originalHttpUrl.newBuilder()
                            .build();

                    // Request customization: add request headers
                    final Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    final Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

            builder.addInterceptor(new ConnectivityInterceptor(AppClass.getAppClass()));

            OkHttpClient client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(WEATHER_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
