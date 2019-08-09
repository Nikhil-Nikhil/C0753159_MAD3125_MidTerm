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

public class HomeActivity extends AppCompatActivity {

 Context context;
    public ArrayList<SatData> mSatData ;

    public ArrayList<SatData> getmSatData() {
        return mSatData;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        processJSON();
        for (int i=0; i<mSatData.size();i++)
        {
            mSatData.get(i).display();
        }
    }
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open("jsonfile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            //Log.d("-- COUNT --", String.format("%d Bytes",count));
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null)
        {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                mSatData = new ArrayList<SatData>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    SatData mSatdata = getFlightDetailObjectFromJSON(mJSONArray.getJSONObject(i));
                    mSatData.add(mSatdata);
                    //Log.d("-- JSON -- ", mSatData.toString());

                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public SatData getFlightDetailObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        String flight_number = userJsonObject.getString("flight_number");
        String mission_name = userJsonObject.getString("mission_name");
        String upcoming = userJsonObject.getString("upcoming");
        String launch_year = userJsonObject.getString("launch_year");
        String launch_window = userJsonObject.getString("launch_window");
        String details = userJsonObject.getString("details");

        //Read Rocket
        JSONObject rocket = new JSONObject(userJsonObject.getJSONObject("rocket").toString());
        String rocket_id = rocket.getString("rocket_id");
        String rocket_name = rocket.getString("rocket_name");
        String rocket_type = rocket.getString("rocket_type");

        //Read Launch Site
        JSONObject launchSite = new JSONObject(userJsonObject.getJSONObject("launch_site").toString());
        String site_id = launchSite.getString("site_id");
        String site_name = launchSite.getString("site_name");
        String site_name_long = launchSite.getString("site_name_long");

        //Read Links
        JSONObject links = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String mission_patch = links.getString("mission_patch");
        String mission_patch_small = links.getString("mission_patch_small");
        String article_link = links.getString("article_link");
        String wikipedia = links.getString("wikipedia");
        String video_link = links.getString("video_link");

        //start creating User object
        SatData mSatdata = new SatData();
        mSatdata.setFlight_number(flight_number);
        mSatdata.setMission_name(mission_name);
        mSatdata.setUpcoming(upcoming);
        mSatdata.setLaunch_year(launch_year);
        mSatdata.setLaunch_window(launch_window);
        mSatdata.setDetails(details);

        Rdata mRocket = new Rdata();
        mRocket.setRocket_id(rocket_id);
        mRocket.setRocket_name(rocket_name);
        mRocket.setRocket_type(rocket_type);
        mSatdata.setRocket(mRocket);

        Launch mLaunchSite = new Launch();
        mLaunchSite.setSite_id(site_id);
        mLaunchSite.setSite_name(site_name);
        mLaunchSite.setSite_name_long(site_name_long);
        mSatdata.setLaunchSite(mLaunchSite);

        Weblinks mLinks = new Weblinks();
        mLinks.setMission_patch(mission_patch);
        mLinks.setMission_patch_small(mission_patch_small);
        mLinks.setArticle_link(article_link);
        mLinks.setWikipedia(wikipedia);
        mLinks.setVideo_link(video_link);
        //mSatData.setLinks(mLinks);

        return mSatdata;
    }

}

       /* MyListData[] myListData = new MyListData[]{
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}*/

