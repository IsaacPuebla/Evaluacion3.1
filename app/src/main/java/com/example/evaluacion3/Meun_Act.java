package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Meun_Act extends AppCompatActivity {
    private Button btnGestion, btnPromo;
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meun_);

        btnGestion=findViewById(R.id.btnGestion);
        btnPromo=findViewById(R.id.btnPromo);
        video=findViewById(R.id.videoView3);
        video.setVideoPath("android.resource://"+ getPackageName() + "/" + R.raw.videopizza);
        video.start();
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {// Permite reproducir el video en bucle
            @Override
            public void onCompletion(MediaPlayer mp) {
                video.start();
            }
        });
    }
    public void Gestion(View v){
        Intent i=new Intent(getBaseContext(),Firebase_act.class);
        startActivity(i);
    }
    public void Promociones(View v){
        Intent i=new Intent(getBaseContext(),Promociones_act.class);
        startActivity(i);
    }
}