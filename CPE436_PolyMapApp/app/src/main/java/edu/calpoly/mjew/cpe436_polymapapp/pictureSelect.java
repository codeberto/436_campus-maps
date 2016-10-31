package edu.calpoly.mjew.cpe436_polymapapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class pictureSelect extends AppCompatActivity {

    String buildingName;
    ListView buildingPics;
    ListAdapter listAd;

    public class ListAdapter extends BaseAdapter{
        Context privContext;
        int itemCount;
        ArrayList<Integer> intList;

        public ListAdapter(Context context){
            privContext = context;
            itemCount = 0;
            intList = new ArrayList<Integer>();
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.pic_entry, parent, false);

            TextView tv = (TextView)  convertView.findViewById(R.id.picText);
            tv.setText(Integer.toString(pos));

            Log.v("getView", "inside");
            itemCount++;
            return convertView;
        }

        @Override
        public int getCount() {
            return itemCount;
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        public void addItem(){
            intList.add(itemCount);
            notifyDataSetChanged();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.pic_fab_options, menu);
        return true;
    }

    // option menu actions
    // move this to fab functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.addPicOp:

                Log.v("addPicOp", "need to get picture from gallery or camera");
                //Intent pictureSelectPage = new Intent(getApplicationContext(), pictureSelect.class);
                //pictureSelectPage.putExtra("BuildingName", buildingName);
                //startActivity(pictureSelectPage);

                listAd.addItem();
                listAd.notifyDataSetChanged();


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_select);

        Intent in = getIntent();
        buildingName = in.getStringExtra("BuildingName");
        this.setTitle(buildingName + "- Photos");

        // TODO: convert to recycleView later on
        listAd = new ListAdapter(this);
        buildingPics = (ListView) findViewById(R.id.picList);
        buildingPics.setAdapter(listAd);



    }
}
