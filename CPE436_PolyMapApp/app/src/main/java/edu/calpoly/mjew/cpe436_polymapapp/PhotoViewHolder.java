package edu.calpoly.mjew.cpe436_polymapapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by cignx on 10/31/16.
 */

public class PhotoViewHolder extends ViewHolder {
    private TextView descV;
    private ImageView imageV;
    private Context privContext;
    public View otherView;

    // pass in a picEntry (layout view)
    public PhotoViewHolder(final View itemView, Context context){
        super(itemView);
        privContext = context;
        descV = (TextView) itemView.findViewById(R.id.picText);
        imageV = (ImageView) itemView.findViewById(R.id.buildingImg);
        otherView = itemView;
    }

    public void bind(String str, Uri imgUri){
        InputStream inputStream;
        descV.setText(str);

        /*if (imgUri != null) {
            privContext.grantUriPermission("com.example.ben.todo_recyclerview", imgUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try {
                inputStream = privContext.getContentResolver().openInputStream(imgUri);
                Bitmap img = BitmapFactory.decodeStream(inputStream);
                imageV.setImageBitmap(img);
            } catch (FileNotFoundException fnf) {
                fnf.printStackTrace();
                Toast.makeText(privContext, "Unable to open image", Toast.LENGTH_LONG).show();
            }
        } else {
            imageV.setImageResource(android.R.color.transparent);
        }*/
    }

}
