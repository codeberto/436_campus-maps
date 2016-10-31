package edu.calpoly.mjew.cpe436_polymapapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


public class buildingLandingPage extends AppCompatActivity {


    LinearLayout currentView;
    String buildingName;

    // code from the android tutorials for menus
    //    Source:
    //    https://developer.android.com/guide/topics/ui/menus.html#options-menu
    // creates an option menu by inflating an xml file
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.fab_options, menu);
        return true;
    }

    // option menu actions
    // move this to fab functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.pictureOp:

                Intent pictureSelectPage = new Intent(getApplicationContext(), pictureSelect.class);
                pictureSelectPage.putExtra("BuildingName", buildingName);
                startActivity(pictureSelectPage);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_landing_page);

        Intent in = getIntent();
        buildingName = in.getStringExtra("BuildingName");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle(buildingName);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

}
