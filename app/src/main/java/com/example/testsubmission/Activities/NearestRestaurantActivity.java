package com.example.testsubmission.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.testsubmission.R;
import com.example.testsubmission.adapters.RestaurantAdapter;
import com.example.testsubmission.adapters.WeatherUpdateAdapter;
import com.example.testsubmission.managers.SharedPreferenceManager;
import com.example.testsubmission.network.handlers.callbacks.RestaurantUpdateCallback;
import com.example.testsubmission.network.models.restaurantResponse.RestaurantResponse;
import com.example.testsubmission.network.models.restaurantResponse.Result;
import com.example.testsubmission.network.models.weatherresponse.Forecastday;
import com.example.testsubmission.network.store.AppStore;
import com.example.testsubmission.utils.ProgressBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.testsubmission.keys.ApiKeys.RESTAURANT_GOOGLE_API_KEYS;
import static com.example.testsubmission.keys.ApiKeys.WEATHER_API_KEYS;

public class NearestRestaurantActivity extends BaseActivity implements RestaurantUpdateCallback {

    @BindView(R.id.rv_restaurant_updates)
    RecyclerView rv_restaurant_updates;

    SharedPreferenceManager sharedPreferenceManager;
    RestaurantAdapter restaurantAdapter;
    String restaurantApiBaseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.nearby_restaurant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);

        String url = restaurantApiBaseUrl + "key=" + RESTAURANT_GOOGLE_API_KEYS
                + "&location=" + sharedPreferenceManager
                .getLatitude() + ","
                + sharedPreferenceManager.getLongitude() +
                "&radius=1000" + "&type=restaurant";

        ProgressBarUtil.showSpinnerProgressDialog(this);
        AppStore.getInstance().getRestaurantUpdates(url, this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_nearest_restaurant;
    }

    private void setUpRecylerView(ArrayList<Result> results) {
        restaurantAdapter = new RestaurantAdapter(results,this);
        rv_restaurant_updates.setLayoutManager(new LinearLayoutManager(this));
        rv_restaurant_updates.setAdapter(restaurantAdapter);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onRestaurantUpdateSuccess(RestaurantResponse restaurantResponse) {
        ProgressBarUtil.hideSpinnerProgressDialog();
        if (restaurantResponse != null) {
            setUpRecylerView((ArrayList<Result>) restaurantResponse.results);
        }
    }



}
