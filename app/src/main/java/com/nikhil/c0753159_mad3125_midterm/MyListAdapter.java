package com.nikhil.c0753159_mad3125_midterm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


// RecyclerView recyclerView;
public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private Context mContext;
    private List<SatData> listdata;
    RequestOptions option;

    public MyListAdapter(Context mContext, List<SatData> listdata) {
        this.mContext = mContext;
        this.listdata = listdata;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.border).error(R.drawable.border);
    }

    // RecyclerView recyclerView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View listItem= layoutInflater.inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.MissionName.setText(listdata.get(position).getMission_name());
        holder.year.setText(listdata.get(position).getLaunch_year());
        Glide.with(mContext.load(listdata.get(position).getFlightimage()).apply(option).into(holder.FlightImage));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewActivity.class);
                //intent.putExtra();
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView MissionName;
         TextView year;
         LinearLayout linearLayout;
         ImageView  FlightImage;
        public ViewHolder(View itemView) {
            super(itemView);
            MissionName = (TextView) itemView.findViewById(R.id.MissionName);
            year = (TextView) itemView.findViewById(R.id.year);
            FlightImage = itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.LinearLayout);

        }
    }
}

