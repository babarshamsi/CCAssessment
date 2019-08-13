package com.example.testsubmission.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.testsubmission.R;
import com.example.testsubmission.network.models.restaurantResponse.Result;
import com.example.testsubmission.viewholders.RestaurantVH;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantVH> {

    ArrayList<Result> restaurantList;
    Context context;
    private LayoutInflater inflater = null;



    public RestaurantAdapter(ArrayList<Result> restaurantList,Context context) {
        this.restaurantList = restaurantList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RestaurantVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_restaurant, parent, false);
        RestaurantVH viewHolder = new RestaurantVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantVH holder, int position) {
        Result restaurantResult = restaurantList.get(position);
        holder.tv_restaurant_name.setText(restaurantResult.name);
        holder.tv_restaurant_location.setText(restaurantResult.vicinity);
        holder.tv_restaurant_food.setText(restaurantResult.scope);
        holder.tv_rating.setText(restaurantResult.rating != null?restaurantResult.rating.toString():"0");
        holder.tv_reviews.setText(restaurantResult.userRatingsTotal!=null?restaurantResult.userRatingsTotal + " Reviews":"0 Reviews");
        holder.rating.setRating(restaurantResult.rating!=null?restaurantResult.rating.intValue():0 );
        Glide.with(context).load(restaurantResult.icon).into(holder.iv_restaurant);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
