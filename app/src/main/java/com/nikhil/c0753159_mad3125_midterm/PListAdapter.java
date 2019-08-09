package com.nikhil.c0753159_mad3125_midterm;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;


// RecyclerView recyclerView;


public class PListAdapter extends RecyclerView.Adapter<PListAdapter.ViewHolder>{

    private PListData[] listdata;

    // RecyclerView recyclerView;
    public PListAdapter(PListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PListData pListData = listdata[position];
        holder.textView.setText(listdata[position].getDescription());
        holder.textView1.setText(listdata[position].getLaunchYear());
        /*String photoUrl = HomeActivity.PListData.get(position).getWebLinks().getMission_patch_small();
        Glide.with(ViewHolder.FlightImage)
                .load(photoUrl)
                .centerCrop()
                .fallback(R.drawable.border)
                .into(ViewHolder.imagepath);
                */
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewActivity.class);
                intent.putExtra("sendData", pListData);
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
      if(listdata == null)
      {
          return 0;
      }
      else
      {
          return  listdata.length;
      }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         TextView textView;
         TextView textView1;
         LinearLayout linearLayout;
        ImageView  FlightImage;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.MissionName);
            this.textView1 = (TextView) itemView.findViewById(R.id.year);
            FlightImage = itemView.findViewById(R.id.FlightImage);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayout);
        }
    }
}
