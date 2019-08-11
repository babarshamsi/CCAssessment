package com.example.testsubmission.network.handlers;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by subhan on 11/25/18.
 */

public abstract class BaseRH<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        Boolean isSuccess = response.isSuccessful();

        if (isSuccess != null && isSuccess) {
            onSuccess(response);
        }
        else if (response.code() == 201){
            onSuccess(response);
        }

        else {
            try {
                if (response.errorBody() != null) {

                        Class<? extends String> errorResponse = response.errorBody().string().getClass();
//                        JSONObject json = new JSONObject(errorResponse);
                        onFailure(errorResponse);


                } else {
                    onFailure(call, null);
                }
            } catch (Exception e) {
                onFailure(call, null);
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Class<? extends Throwable> errorResponse = t.getClass();
        onFailure(errorResponse);
    }

    protected abstract void onSuccess(Response<T> response);
    protected abstract void onFailure(Class<?> response);

}