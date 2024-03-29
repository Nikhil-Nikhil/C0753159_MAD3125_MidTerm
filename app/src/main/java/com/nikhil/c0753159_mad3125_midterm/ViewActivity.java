package com.nikhil.c0753159_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    TextView txtMissionName, txtFlightNumber, txtLaunchYear, txtRocketId, txtRocketType;
    PListData pListData;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        pListData = (PListData) getIntent().getSerializableExtra("sendData");
        init();
        setData();
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ViewActivity.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setData() {
        txtMissionName.setText("Mission Name: " + pListData.getMissionName());

        txtLaunchYear.setText("Launch Year: " + pListData.getLaunchYear());
    }

    private void init() {
        txtMissionName = (TextView) findViewById(R.id.MissionName);

        txtLaunchYear = (TextView) findViewById(R.id.year);
    }
}
