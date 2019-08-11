package com.example.testsubmission.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.testsubmission.R;
import com.example.testsubmission.network.models.weatherresponse.Forecastday;
import com.example.testsubmission.utils.DateFormatter;
import com.example.testsubmission.viewholders.WeatherVH;

import java.util.ArrayList;

public class WeatherUpdateAdapter extends RecyclerView.Adapter<WeatherVH> {

    ArrayList<Forecastday> forecastdays;
    private  LayoutInflater inflater = null;
    Context context;

    public WeatherUpdateAdapter(ArrayList<Forecastday> forecastdays,Context context){
        this.forecastdays = forecastdays;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;

    }

    @Override
    public WeatherVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_day_weather, parent, false);
        WeatherVH viewHolder = new WeatherVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherVH holder, int position) {
        Forecastday forecastday = forecastdays.get(position);
        holder.tv_day.setText(DateFormatter.getShortDayName(forecastday.getDate()));
        holder.tv_max_temp.setText(forecastday.getDay().getMaxtempC().toString());
        holder.tv_min_temp.setText(forecastday.getDay().getMintempC().toString());
        Glide.with(context).load(forecastday.getDay().getCondition().getIcon());
    }

    @Override
    public int getItemCount() {
        return forecastdays.size();
    }
}
