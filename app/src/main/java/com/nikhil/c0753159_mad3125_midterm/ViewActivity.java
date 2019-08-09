package com.nikhil.c0753159_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    TextView txtMissionName,txtFlightNumber,txtLaunchYear,txtRocketId,txtRocketType;
    MyListData myListData;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ViewActivity.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
            }
        });
        myListData = (MyListData) getIntent().getSerializableExtra("sendData");
        //init();
        setData();
    }
   /* public void init() {
        txtMissionName = (TextView) findViewById(R.id.txtMissionName);
        txtFlightNumber = (TextView) findViewById(R.id.txtFlightNumber);
        txtLaunchYear = (TextView) findViewById(R.id.txtLaunchYear);
        txtRocketId = (TextView) findViewById(R.id.txtRocketId);
        txtRocketType = (TextView) findViewById(R.id.txtRocketType);
    }*/
    public void setData() {
        txtMissionName.setText("Mission Name: "+myListData.getMissionName());
        txtFlightNumber.setText("Flight Number: "+myListData.getFlightNumber());
        txtLaunchYear.setText("Launch Year: "+myListData.getLaunchYear());
        txtRocketId.setText("Rocket Id: "+myListData.getRocketId());
        txtRocketType.setText("Rocket Type: "+myListData.getRocketType());
    }


    }
