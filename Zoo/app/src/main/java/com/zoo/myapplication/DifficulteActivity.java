package com.zoo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class DifficulteActivity extends AppCompatActivity {

    public ImageButton easy;
    public ImageButton normal;
    public ImageButton hard;
    public String difficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulte);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        easy =(ImageButton) findViewById(R.id.easyButton);
        normal =(ImageButton) findViewById(R.id.normalButton);
        hard =(ImageButton) findViewById(R.id.hardButton);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameEasy();
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameNormal();
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameHard();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent;
                intent = new Intent(this,MainActivity.class);

                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void startGameEasy(){
        Intent intent;
        intent = new Intent(this,JeuActivity.class);
        difficulty = "easy";
        intent.putExtra("difficulte", difficulty);
        startActivity(intent);
    }
    public void startGameNormal(){
        Intent intent;
        intent = new Intent(this,JeuActivity.class);
        difficulty = "normal";
        intent.putExtra("difficulte", difficulty);
        startActivity(intent);
    }
    public void startGameHard(){
        Intent intent;
        intent = new Intent(this,JeuActivity.class);
        difficulty = "hard";
        intent.putExtra("difficulte", difficulty);
        startActivity(intent);
    }
}
