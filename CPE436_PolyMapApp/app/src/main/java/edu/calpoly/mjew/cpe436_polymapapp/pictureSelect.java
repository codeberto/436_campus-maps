package edu.calpoly.mjew.cpe436_polymapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class pictureSelect extends AppCompatActivity {

    String buildingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_select);

        Intent in = getIntent();
        buildingName = in.getStringExtra("BuildingName");

        this.setTitle(buildingName);
    }
}
