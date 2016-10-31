package edu.calpoly.mjew.cpe436_polymapapp;

import android.support.v4.util.Pools;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.R.layout;

public class entry_page extends AppCompatActivity {

    // TODO: update buildings.xml with info from
    //      https://afd.calpoly.edu/facilities/spacefacility/name_buildings.pdf
    //  update names to be major specific?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_page);

        Spinner buildingList = (Spinner) findViewById(R.id.buildingSelection);
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this,
                R.array.buildings, layout.simple_spinner_item);
        spinAdapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
        buildingList.setAdapter(spinAdapter);
    }
}
