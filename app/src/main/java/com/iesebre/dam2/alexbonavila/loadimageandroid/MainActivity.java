package com.iesebre.dam2.alexbonavila.loadimageandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity{


    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mImageView = (ImageView) findViewById(R.id.IMG);

    }


    protected Bitmap downloadImage(String url){
        try {

            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());

            return bitmap;

        } catch (Exception e) {

            System.out.print(e);

        }

        return null;
    }


    public void onClick(View view) {
        new Thread(new Runnable() {
            public void run() {
                final Bitmap bitmap = downloadImage("http://helgram.com/content/uploads/2013/11/compilashun_error_thumb_night.jpg");
                mImageView.post(new Runnable() {
                    public void run() {
                        mImageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
}
