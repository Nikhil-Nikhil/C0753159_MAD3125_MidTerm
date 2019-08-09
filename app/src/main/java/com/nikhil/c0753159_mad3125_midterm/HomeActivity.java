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

public class HomeActivity extends AppCompatActivity
{
    String key = "";
    String value = "";
    public MyListData[] myListData;
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
                    System.out.println(mObject.get("mission_name"));
                    System.out.println(mObject.get("launch_year"));
                    value = mObject.get("mission_name").toString();
                    key = mObject.get("launch_year").toString();

                    MyListData myListData1 = new MyListData(value);
                    MyListData myListData2 = new MyListData(key);

                    MyListData.DataList.add(myListData1);
                    MyListData.DataList.add(myListData2);
                    Log.d("DATA", mObject.toString());
                }
                myListData = MyListData.DataList.toArray(new MyListData [MyListData.DataList.size()]);

//                myListData = MyListData.DataList.toArray();

                System.out.println(
                        MyListData.DataList
                );
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
//

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
//        System.out.println(json);
        return json;



//
    }

}
