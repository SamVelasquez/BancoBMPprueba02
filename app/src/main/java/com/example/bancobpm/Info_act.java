package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoView = (VideoView)findViewById(R.id.videoView);
        // colocamos la ruta donde se encuentra nuestro video
        String ruta= "android.resource:// " + getPackageName()+ "/" + R.raw.video;
        Uri uri= Uri.parse(ruta);
        videoView.setVideoURI(uri);
        // controles de navegacion
        MediaController media=  new MediaController(this);
        videoView.setMediaController(media);
    }
    public void mapas (View view){
        Intent mapas = new Intent(this, MapsActivity.class);
        startActivity(mapas);
    }
}