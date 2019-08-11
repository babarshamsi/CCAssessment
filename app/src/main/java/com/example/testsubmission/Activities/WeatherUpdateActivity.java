package com.example.testsubmission.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testsubmission.R;
import com.example.testsubmission.adapters.WeatherUpdateAdapter;
import com.example.testsubmission.managers.SharedPreferenceManager;
import com.example.testsubmission.network.handlers.callbacks.WeatherUpdateCallback;
import com.example.testsubmission.network.models.weatherresponse.Forecastday;
import com.example.testsubmission.network.models.weatherresponse.WeatherForcastResponse;
import com.example.testsubmission.network.store.AppStore;
import com.example.testsubmission.utils.DateFormatter;
import com.example.testsubmission.utils.ProgressBarUtil;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.testsubmission.keys.ApiKeys.WEATHER_API_KEYS;

public class WeatherUpdateActivity extends BaseActivity implements WeatherUpdateCallback {

    @BindView(R.id.rv_weather_updates)
    RecyclerView rv_weather_updates;

    @BindView(R.id.tv_city_name)
    TextView tv_city_name;

    @BindView(R.id.tv_day)
    TextView tv_day;

    @BindView(R.id.tv_weather_condition)
    TextView tv_weather_condition;

    @BindView(R.id.tv_current_temp)
    TextView tv_current_temp;

    @BindView(R.id.tv_precipitation)
    TextView tv_precipitation;

    @BindView(R.id.tv_humidity)
    TextView tv_humidity;

    @BindView(R.id.tv_wind_speed)
    TextView tv_wind_speed;

    @BindView(R.id.iv_current_weather)
    ImageView iv_current_weather;

    SharedPreferenceManager sharedPreferenceManager;
    WeatherUpdateAdapter weatherUpdateAdapter;
    String weatherApiBaseUrl = "https://api.apixu.com/v1/forecast.json?";



    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        ButterKnife.bind(this);
        attachClickListener(R.id.bt_restaurant);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);

        String url = weatherApiBaseUrl + "key=" + WEATHER_API_KEYS
                + "&q=" + sharedPreferenceManager
                .getLatitude() + ","
                + sharedPreferenceManager.getLongitude() +
                "&days=5";

        LatLng latLng = new LatLng(sharedPreferenceManager.getLatitude(),
                sharedPreferenceManager.getLongitude());
        ProgressBarUtil.showSpinnerProgressDialog(this);
        AppStore.getInstance().getWeatherUpdates(url, this);
//        AppStore.getInstance().getWeatherUpdates(WEATHER_API_KEYS,latLng,
//                5, this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_weather_update;
    }


    private void setUpRecylerView(ArrayList<Forecastday> list) {
        if (list.size() > 0) {
            weatherUpdateAdapter = new WeatherUpdateAdapter(list, this);
            rv_weather_updates.setLayoutManager(new LinearLayoutManager(this));
            rv_weather_updates.setAdapter(weatherUpdateAdapter);
        }
    }

    private void settingweatherData(WeatherForcastResponse weatherForcastResponse) {
        tv_city_name.setText(weatherForcastResponse.getLocation().getName());
        tv_day.setText(DateFormatter.getFullDayName(weatherForcastResponse.getLocation().getLocaltime()));
        tv_weather_condition.setText(weatherForcastResponse.getCurrent().getCondition().getText());
        tv_current_temp.setText(weatherForcastResponse.getCurrent().getTempC().toString());
        tv_precipitation.setText(String.valueOf(Math.round(weatherForcastResponse.getCurrent().getPrecipIn())));
        tv_humidity.setText(weatherForcastResponse.getCurrent().getHumidity().toString());
        tv_wind_speed.setText(weatherForcastResponse.getCurrent().getWindKph().toString());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_restaurant:
                gotoActivity(NearestRestaurantActivity.class);
        }
    }

    @Override
    public void onWeatherUpdateSuccess(WeatherForcastResponse weatherForcastResponse) {
        ProgressBarUtil.hideSpinnerProgressDialog();
        if (weatherForcastResponse != null) {
            settingweatherData(weatherForcastResponse);
            setUpRecylerView((ArrayList<Forecastday>) weatherForcastResponse.getForecast().getForecastday());
        }
    }


}
