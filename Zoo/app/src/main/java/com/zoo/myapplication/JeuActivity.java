package com.zoo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JeuActivity extends AppCompatActivity {

    public String difficulty;
    private LinearLayout layoutImages;
    private LinearLayout layoutLettres;
    private ImageButton skipbutton;
    private EditText lettre1;
    private EditText lettre2;
    private EditText lettre3;
    private EditText lettre4;
    private EditText lettre5;
    private EditText lettre6;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    public Button valider;
    public AnimauxJeu animauxJeu;
    public int longueur ;
    public List<Animal> animauxReussis ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);
        skipbutton = (ImageButton) findViewById(R.id.skipButton);
        layoutImages = (LinearLayout) findViewById(R.id.layoutImages);
        layoutLettres = (LinearLayout) findViewById(R.id.layoutLettres);
        valider = (Button) findViewById(R.id.ValiderButton);
        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animauxJeu.animaux.size()==1){
                    startVictoire();
                }else{
                    animauxSuivant();
                }

            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            difficulty = "";
            if (intent.hasExtra("difficulte")) {
                difficulty = intent.getStringExtra("difficulte");
            }
            if (intent.hasExtra("animauxReussis")) {
                animauxReussis = (List<Animal>) intent.getSerializableExtra("animauxReussis");
            }else{
                animauxReussis = new ArrayList<>();
            }
            if (intent.hasExtra("classJeu")) {
                animauxJeu = (AnimauxJeu) intent.getSerializableExtra("classJeu");
            }else {
                animauxJeu = new AnimauxJeu(difficulty);
                animauxJeu.genererListe();
            }

        }
        image1 = new ImageView(this);
        image2 = new ImageView(this);
        image3 = new ImageView(this);
        lettre1 = new EditText(this);
        lettre2 = new EditText(this);
        lettre3 = new EditText(this);
        lettre1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        lettre2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        lettre3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        layoutImages.addView(image1);
        layoutImages.addView(image2);
        layoutImages.addView(image3);
        layoutLettres.addView(lettre1);
        layoutLettres.addView(lettre2);
        layoutLettres.addView(lettre3);

        if (animauxJeu.longueurAnimal() >= 4) {
            image4 = new ImageView(this);
            layoutImages.addView(image4);
            lettre4 = new EditText(this);
            lettre4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            layoutLettres.addView(lettre4);
        }
        if (animauxJeu.longueurAnimal() >= 5) {
            image5 = new ImageView(this);
            layoutImages.addView(image5);
            lettre5 = new EditText(this);
            lettre5.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            layoutLettres.addView(lettre5);
        }
        if (animauxJeu.longueurAnimal() == 6) {
            image6 = new ImageView(this);
            layoutImages.addView(image6);
            lettre6 = new EditText(this);
            lettre6.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            layoutLettres.addView(lettre6);
        }


        int random = (int) (Math.random() * animauxJeu.getAnimal().GetLongueur() + 1);

        switch (random) {
            case 1:
                lettre1.setText(animauxJeu.getAnimal().lettres.get(0).toString());
                image1.setScaleType(ImageView.ScaleType.FIT_XY);
                image1.setImageResource(animauxJeu.getAnimal().partie.get(0));
                break;
            case 2:
                lettre2.setText(animauxJeu.getAnimal().lettres.get(1).toString());
                image2.setScaleType(ImageView.ScaleType.FIT_XY);
                image2.setImageResource(animauxJeu.getAnimal().partie.get(1));
                break;
            case 3:
                lettre3.setText(animauxJeu.getAnimal().lettres.get(2).toString());
                image3.setScaleType(ImageView.ScaleType.FIT_XY);
                image3.setImageResource(animauxJeu.getAnimal().partie.get(2));
                break;
            case 4:
                lettre4.setText(animauxJeu.getAnimal().lettres.get(3).toString());
                image4.setImageResource(animauxJeu.getAnimal().partie.get(3));
                image4.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case 5:
                lettre5.setText(animauxJeu.getAnimal().lettres.get(4).toString());
                image5.setImageResource(animauxJeu.getAnimal().partie.get(4));
                image5.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case 6:
                lettre6.setText(animauxJeu.getAnimal().lettres.get(5).toString());
                image6.setScaleType(ImageView.ScaleType.FIT_XY);
                image6.setImageResource(animauxJeu.getAnimal().partie.get(5));
                break;
        }
            lettre1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!lettre1.getText().toString().equals("")) {
                        lettre2.requestFocus();
                        if (lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())) {
                            image1.setVisibility(View.VISIBLE);
                            image1.setScaleType(ImageView.ScaleType.FIT_XY);
                            image1.setImageResource(animauxJeu.getAnimal().partie.get(0));
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())) {
                        image1.setVisibility(View.INVISIBLE);
                    }
                }
            });
            lettre2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!lettre2.getText().toString().equals("")) {
                        lettre3.requestFocus();
                        if (lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())) {
                            image2.setVisibility(View.VISIBLE);
                            image2.setScaleType(ImageView.ScaleType.FIT_XY);
                            image2.setImageResource(animauxJeu.getAnimal().partie.get(1));
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())) {
                        image2.setVisibility(View.INVISIBLE);
                    }
                }
            });
            lettre3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!lettre3.getText().toString().equals("")) {
                        if (animauxJeu.longueurAnimal() == 4) {
                            lettre4.requestFocus();
                        } else {

                        }
                        if (lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())) {
                            image3.setVisibility(View.VISIBLE);
                            image3.setScaleType(ImageView.ScaleType.FIT_XY);
                            image3.setImageResource(animauxJeu.getAnimal().partie.get(2));

                        }

                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())){
                        image3.setVisibility(View.INVISIBLE);
                    }
                }
            });
            if (animauxJeu.longueurAnimal() >= 4) {
                lettre4.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (lettre4.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(3).toString())) {
                            image4.setVisibility(View.VISIBLE);
                            image4.setScaleType(ImageView.ScaleType.FIT_XY);
                            image4.setImageResource(animauxJeu.getAnimal().partie.get(3));
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(!lettre4.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(3).toString())) {
                            image4.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        if (animauxJeu.longueurAnimal() >= 5) {
            lettre5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (lettre5.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(4).toString())) {
                        image5.setVisibility(View.VISIBLE);
                        image5.setScaleType(ImageView.ScaleType.FIT_XY);
                        image5.setImageResource(animauxJeu.getAnimal().partie.get(4));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!lettre5.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(4).toString())) {
                        image5.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
        if (animauxJeu.longueurAnimal() >= 6) {
            lettre6.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (lettre6.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(5).toString())) {
                        image6.setVisibility(View.VISIBLE);
                        image6.setScaleType(ImageView.ScaleType.FIT_XY);
                        image6.setImageResource(animauxJeu.getAnimal().partie.get(5));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!lettre6.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(5).toString())){
                        image6.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
           valider.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   longueur= animauxJeu.longueurAnimal();
                   switch(longueur){
                       case 3:
                           if(lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())&
                                   lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())&
                                   lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())){
                               if (animauxJeu.animaux.size()==1){
                                    startVictoire();
                               }else{
                                   animauxReussis.add(animauxJeu.getAnimal());
                                   animauxSuivant();
                               }
                           }
                       break;
                       case 4:
                           if(lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())&
                                   lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())&
                                   lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())&
                                   lettre4.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(3).toString())){
                               if (animauxJeu.animaux.size()==1){
                                   startVictoire();
                               }else{
                                   animauxReussis.add(animauxJeu.getAnimal());
                                   animauxSuivant();
                               }
                           }
                       break;
                       case 5:
                           if(lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())&
                                   lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())&
                                   lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())&
                                   lettre4.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(3).toString())&
                                   lettre5.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(4).toString())){
                               if (animauxJeu.animaux.size()==1){
                                   startVictoire();
                               }else{
                                   animauxReussis.add(animauxJeu.getAnimal());
                                   animauxSuivant();
                               }
                           }
                        break;
                       case 6:
                           if(lettre1.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(0).toString())&
                                   lettre2.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(1).toString())&
                                   lettre3.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(2).toString())&
                                   lettre4.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(3).toString())&
                                   lettre5.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(4).toString())&
                                   lettre6.getText().toString().equalsIgnoreCase(animauxJeu.getAnimal().lettres.get(5).toString())){
                               if (animauxJeu.animaux.size()==1){
                                   startVictoire();
                               }else{
                                   animauxReussis.add(animauxJeu.getAnimal());
                                   animauxSuivant();
                               }
                           }
                       break;
                   }
               }
           });

        }

    public void startVictoire(){
        Intent intent;

        intent = new Intent(this,VictoireActivity.class);

        startActivity(intent);
    }

    public void afficheLettre(){
    }
    public void animauxSuivant(){
        animauxJeu.animaux.remove(0);
        Intent intent;


        intent = new Intent(this,JeuActivity.class);
        intent.putExtra("difficulte", difficulty);
        intent.putExtra("animauxReussis", (Serializable)animauxReussis);
        intent.putExtra("classJeu",animauxJeu);
        startActivity(intent);
    }
}
