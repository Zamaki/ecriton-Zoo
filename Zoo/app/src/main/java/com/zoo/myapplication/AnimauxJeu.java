package com.zoo.myapplication;

import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AnimauxJeu implements Serializable {

    public List<Animal> animaux;
    public String difficulte;

    public AnimauxJeu(String difficulte){
        this.difficulte=difficulte;
        animaux = new ArrayList<>();
    }

    public void genererListe(){
        switch(difficulte){
            case "easy":
                animaux.add(new Animal("Ane"));
                animaux.add(new Animal("Chat"));
                animaux.add(new Animal("Lion"));
                animaux.add(new Animal("Cerf"));
                animaux.add(new Animal("Lama"));
                animaux.add(new Animal("Loup"));
                animaux.add(new Animal("Ours"));
                 break;
            case "normal":
                animaux.add(new Animal("Chien"));
                animaux.add(new Animal("Singe"));
                animaux.add(new Animal("Tigre"));
                animaux.add(new Animal("Vache"));
                animaux.add(new Animal("Zebre"));
                animaux.add(new Animal("Bison"));
                animaux.add(new Animal("Renne"));
                 break;
            case "hard":
                animaux.add(new Animal("Girafe"));
                animaux.add(new Animal("Jaguar"));
                animaux.add(new Animal("Renard"));
                animaux.add(new Animal("Mouton"));
                animaux.add(new Animal("Cheval"));
                animaux.add(new Animal("Cochon"));
                animaux.add(new Animal("Tortue"));
                 break;
        }
        Collections.shuffle(animaux);
        animaux.remove(0);
        animaux.remove(0);
    }

    public String getDifficulte() {
        return difficulte;
    }

    public int longueurAnimal(){
        return animaux.get(0).GetLongueur();
    }

    public Animal getAnimal(){
        return animaux.get(0);
    }

}
