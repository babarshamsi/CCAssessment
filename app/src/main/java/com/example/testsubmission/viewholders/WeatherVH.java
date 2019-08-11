package com.example.testsubmission.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testsubmission.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherVH extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_day)
   public TextView tv_day;

    @BindView(R.id.tv_max_temp)
    public TextView tv_max_temp;

    @BindView(R.id.tv_min_temp)
    public TextView tv_min_temp;

    @BindView(R.id.iv_weather)
    public ImageView iv_weather;


    public WeatherVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
