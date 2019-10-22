package com.zoo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VictoireActivity extends AppCompatActivity {

    ImageButton zoobutton;
    ImageButton replaybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victoire);

        replaybutton =(ImageButton) findViewById(R.id.replayButton);
        replaybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDifficulte();
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

    public void startDifficulte(){
        Intent intent;
        intent = new Intent(this,DifficulteActivity.class);

        startActivity(intent);
    }
}
