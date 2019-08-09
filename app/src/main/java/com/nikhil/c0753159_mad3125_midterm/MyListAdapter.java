package com.nikhil.c0753159_mad3125_midterm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


// RecyclerView recyclerView;
public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.MissionName.setText(listdata[position].getDescription());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewActivity.class);
                //intent.putExtra();
               // i.putExtra("id",stuId);
                //i.putExtra("name",stuName);
                //i.putExtra("email",stuEmail);
                //mStudent.setId(stuId);
                //mStudent.setName(stuName);
                //mStudent.setEmail(stuEmail);
                //i.putExtra("student",mStudent);
                //startActivity(i);
                view.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView MissionName;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.MissionName = (TextView) itemView.findViewById(R.id.MissionName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayout);
        }
    }
}


