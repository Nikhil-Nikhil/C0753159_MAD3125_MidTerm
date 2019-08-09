package com.nikhil.c0753159_mad3125_midterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements MyRecycler{
    public ArrayList<SatData> mSatData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        String userJson = null;
        try {
            userJson = loadJSONFromAsset();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(userJson != null)
        {

            try
            {
                JSONArray mJSONArray = new JSONArray(userJson);
                for (int i = 0; i < mJSONArray.length(); i++)
                {
                    JSONObject mObject = mJSONArray.getJSONObject(i);
                    System.out.println("----------------");
                   // System.out.println(mObject.get("mission_name"));
                    //Log.d("DATA", mObject.toString());
                    SatData mSatdata = new SatData();
                    mSatdata.setFlight_number(mObject.get("flight_number").toString());
                    mSatdata.setMission_name(mObject.get("mission_name").toString());
                    mSatdata.setLaunch_year(mObject.get("launch_year").toString());
                    mSatdata.setUpcoming(mObject.get("upcoming").toString());
                    mSatdata.display();




                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }


    public String loadJSONFromAsset() throws JSONException {
        String json;
        try {
            InputStream is = getAssets().open("jsonfile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        SatData adapter = new MyListAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


