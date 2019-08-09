package com.nikhil.c0753159_mad3125_midterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeActivity extends AppCompatActivity {



        private static final String TAG = "HomeActivity";
        String jsonString;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            try {
                jsonString = readFile("json_file");
                Log.e(TAG, "onCreate: "+jsonString);
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i =0 ; i<jsonArray.length() ; i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    String flight = object.getString("flight_number");
                    Log.e(TAG, "onCreate: "+flight );
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

          //  init();
        }

    private void init() {
    }


    public String readFile(String fileName) throws IOException
        {
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));

            String content = "";
            String line;
            while ((line = reader.readLine()) != null)
            {
                content = content + line;
            }

            return content;

        }
    }

