package com.zoo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton playbutton;
    ImageButton zoobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton =(ImageButton) findViewById(R.id.playButton);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

      zoobutton =(ImageButton) findViewById(R.id.zooButton);
        zoobutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startZoo();
           }
       });
    }

    public void startZoo(){
        Intent intent;
        intent = new Intent(this,ZooActivity.class);

        startActivity(intent);
    }

    public void startGame(){
        Intent intent;
        intent = new Intent(this,DifficulteActivity.class);

        startActivity(intent);
    }
}


