package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView videoView;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoView =(VideoView)findViewById(R.id.videoView);
        //se coloca la ruta para que pueda acceder al video
        String ruta = "android.resource://"+ getPackageName()+ "/" + R.raw.video;
        Uri uri= Uri.parse(ruta);
        videoView.setVideoURI(uri);
        // controles de navegacion
        MediaController media=  new MediaController(this);
        videoView.setMediaController(media);
        textView3=(TextView)findViewById(R.id.textView3);
        textView3.setText("Bienvenido al Banco BPM donde podras solicitar tus finanzas y solicitar prestamos de nuestros banco ofrecemos los mejores beneficios.");
    }
    public void mapas (View view){
        Intent mapas = new Intent(this, MapsActivity.class);
        startActivity(mapas);
    }
}