package com.nikhil.c0753159_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HomeActivity extends AppCompatActivity {
    String rocketId = "";
    String missionName = "";
    String flightNumber;
    String launchYear;
    String rocketType;
    String imgPathSmall;
    String imgPath;
    public PListData[] pListData;
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
                JSONArray mJSONArray1;
                for (int i = 0; i < mJSONArray.length(); i++)
                {
                    JSONObject mObject = mJSONArray.getJSONObject(i);
                    JSONObject mObject2;
                    JSONObject mObject3;

                    System.out.println("----------------");
                    System.out.println(mObject.get("mission_name"));

                    missionName = mObject.get("mission_name").toString();
                    flightNumber = mObject.get("flight_number").toString();
                    launchYear = mObject.get("launch_year").toString();

                    mObject2 = mObject.getJSONObject("rocket");
                    rocketId = mObject2.getString("rocket_id");
                    rocketType = mObject2.getString("rocket_type");
                    System.out.println("==========="+rocketId);

                    mObject3 = mObject.getJSONObject("links");
                    imgPath = mObject3.getString("mission_patch");
                    imgPathSmall = mObject3.getString("mission_patch_small");

                    PListData pListData1 = new PListData(missionName,flightNumber,launchYear,rocketId,rocketType,imgPath,imgPathSmall);

                    PListData.DataList.add(pListData1);
                    Log.d("DATA", mObject.toString());
                }
                //System.out.println(rocketId);
                pListData = PListData.DataList.toArray(new PListData[PListData.DataList.size()]);

//                pListData = PListData.DataList.toArray();

                System.out.println(
                        PListData.DataList
                );
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
//

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        PListAdapter adapter = new PListAdapter(pListData);
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
        System.out.println(json);
        return json;



//
    }
}
