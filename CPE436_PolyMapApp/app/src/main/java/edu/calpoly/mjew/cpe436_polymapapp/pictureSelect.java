package edu.calpoly.mjew.cpe436_polymapapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.TextView;

import java.util.ArrayList;

import static android.Manifest.permission.CAMERA;

public class pictureSelect extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_GALLERY = 1;
    String buildingName;
    RecyclerView buildingRV;
    PhotoAdapter photoAd;

    private ArrayList<String> descList;
    private ArrayList<Uri> imgList;

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
            case R.id.addCameraOp:

                Log.v("addPicOp", "need to get picture from gallery or camera");
                //Intent pictureSelectPage = new Intent(getApplicationContext(), pictureSelect.class);
                //pictureSelectPage.putExtra("BuildingName", buildingName);
                //startActivity(pictureSelectPage);


                Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (mayRequestCamera()) {
                    Log.v("permission Granted", "good to go");
                    startActivityForResult(takePic, REQUEST_CAMERA);
                }
                return true;

            case R.id.addGalleryOp:
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, REQUEST_GALLERY);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA || requestCode == REQUEST_GALLERY) {
                Log.v("actResult", "received results");
                descList.add(buildingName);
                imgList.add(null);
                photoAd.notifyDataSetChanged();
            }
        }
    }

    // TODO: need to format all pictures to be the same size - then do a wrap content height for .xml


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_select);

        Intent in = getIntent();
        buildingName = in.getStringExtra("BuildingName");
        this.setTitle(buildingName + "- Photos");


        if(descList == null)
        {
            descList = new ArrayList<>();
        }
        if(imgList == null)
        {
            imgList = new ArrayList<>();
        }


        buildingRV = (RecyclerView) findViewById(R.id.picList);
        assert buildingRV != null;
        buildingRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        photoAd = new PhotoAdapter(descList, imgList, this);
        buildingRV.setAdapter(photoAd);
    }

    private boolean mayRequestCamera() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(CAMERA)) {
            Snackbar.make(buildingRV, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                        }
                    });
        } else {
            requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
        }
        return false;
    }
}
