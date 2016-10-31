package edu.calpoly.mjew.cpe436_polymapapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by cignx on 10/31/16.
 */

public class PhotoAdapter extends RecyclerView.Adapter{

    private ArrayList<String> descList;
    private ArrayList<Uri> imgList;
    private Context privContext;

    // use for orientation switch
    public PhotoAdapter(ArrayList<String> items, ArrayList<Uri> imgs, Context context){

        this.descList = items;
        this.imgList = imgs;
        this.privContext = context;
    }

    public ArrayList<String> getDescList(){
        return this.descList;
    }

    public ArrayList<Uri> getImgList(){
        return this.imgList;
    }

    @Override
    public int getItemViewType(int position){
        return R.layout.pic_entry;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
        PhotoViewHolder holder = new PhotoViewHolder(v, privContext);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final PhotoViewHolder pvHolder = (PhotoViewHolder) holder;
        pvHolder.bind(descList.get(position), imgList.get(position));

        // once clicked, go to the expanded img/description view
        // TODO: see above
        /*holder.otherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editAct = new Intent(privContext, ToDoEdit_Main.class);

                // get the position of the task entry being edited
                // put into retain data item so that position is saved on orientation flip
                saveData.retainPos = pvHolder.getAdapterPosition();
                editAct.putExtra("taskPos", saveData.retainPos);

                startActivityForResult(editAct, CODE_CHILD);
            }
        });*/
    }

    @Override
    public int getItemCount(){
        return descList.size();
    }

}
