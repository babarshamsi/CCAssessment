package com.example.testsubmission.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.testsubmission.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantVH extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_restaurant_name)
    public TextView tv_restaurant_name;

    @BindView(R.id.tv_restaurant_location)
    public TextView tv_restaurant_location;

    @BindView(R.id.tv_restaurant_food)
    public TextView tv_restaurant_food;

    @BindView(R.id.tv_rating)
    public TextView tv_rating;

    @BindView(R.id.tv_reviews)
    public TextView tv_reviews;

    @BindView(R.id.iv_restaurant)
    public ImageView iv_restaurant;

    @BindView(R.id.rating)
    public RatingBar rating;

    public RestaurantVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
