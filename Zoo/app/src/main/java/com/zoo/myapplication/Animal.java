package com.zoo.myapplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {

    public String nom;
    public List<Character> lettres;
    public List<Integer> partie;


    public Animal(String nom) {
        lettres = new ArrayList<>();
        partie = new ArrayList<>();
        this.nom=nom;

        for (int i=0; i<nom.length(); i++){
            lettres.add(nom.charAt(i));
        }
        switch(nom) {
            case "Ane":
                partie.add(R.drawable.ane1);
                partie.add(R.drawable.ane2);
                partie.add(R.drawable.ane3);

                break;
            case "Chat":
                partie.add(R.drawable.chat1);
                partie.add(R.drawable.chat2);
                partie.add(R.drawable.chat3);
                partie.add(R.drawable.chat4);
                break;
            case "Lion":
                partie.add(R.drawable.lion1);
                partie.add(R.drawable.lion2);
                partie.add(R.drawable.lion3);
                partie.add(R.drawable.lion4);
                break;
            case "Cerf":
                partie.add(R.drawable.cerf1);
                partie.add(R.drawable.cerf2);
                partie.add(R.drawable.cerf3);
                partie.add(R.drawable.cerf4);
                break;
            case "Lama":
                partie.add(R.drawable.lama1);
                partie.add(R.drawable.lama2);
                partie.add(R.drawable.lama3);
                partie.add(R.drawable.lama4);
                break;
            case "Loup":
                partie.add(R.drawable.loup1);
                partie.add(R.drawable.loup2);
                partie.add(R.drawable.loup3);
                partie.add(R.drawable.loup4);
                break;
            case "Ours":
                partie.add(R.drawable.ours1);
                partie.add(R.drawable.ours2);
                partie.add(R.drawable.ours3);
                partie.add(R.drawable.ours4);
                break;
            case "Bison":
                partie.add(R.drawable.bison1);
                partie.add(R.drawable.bison2);
                partie.add(R.drawable.bison3);
                partie.add(R.drawable.bison4);
                partie.add(R.drawable.bison5);
                break;
            case "Cheval":
                partie.add(R.drawable.cheval1);
                partie.add(R.drawable.cheval2);
                partie.add(R.drawable.cheval3);
                partie.add(R.drawable.cheval4);
                partie.add(R.drawable.cheval5);
                partie.add(R.drawable.cheval6);
                break;
            case "Chien":
                partie.add(R.drawable.chien1);
                partie.add(R.drawable.chien2);
                partie.add(R.drawable.chien3);
                partie.add(R.drawable.chien4);
                partie.add(R.drawable.chien5);
                break;
            case "Cochon":
                partie.add(R.drawable.cochon1);
                partie.add(R.drawable.cochon2);
                partie.add(R.drawable.cochon3);
                partie.add(R.drawable.cochon4);
                partie.add(R.drawable.cochon5);
                partie.add(R.drawable.cochon6);
                break;
            case "Girafe":
                partie.add(R.drawable.girafe1);
                partie.add(R.drawable.girafe2);
                partie.add(R.drawable.girafe3);
                partie.add(R.drawable.girafe4);
                partie.add(R.drawable.girafe5);
                partie.add(R.drawable.girafe6);
                break;
            case "Jaguar":
                partie.add(R.drawable.jaguar1);
                partie.add(R.drawable.jaguar2);
                partie.add(R.drawable.jaguar3);
                partie.add(R.drawable.jaguar4);
                partie.add(R.drawable.jaguar5);
                partie.add(R.drawable.jaguar6);
                break;
            case "Mouton":
                partie.add(R.drawable.mouton1);
                partie.add(R.drawable.mouton2);
                partie.add(R.drawable.mouton3);
                partie.add(R.drawable.mouton4);
                partie.add(R.drawable.mouton5);
                partie.add(R.drawable.mouton6);
                break;
            case "Renard":
                partie.add(R.drawable.renard1);
                partie.add(R.drawable.renard2);
                partie.add(R.drawable.renard3);
                partie.add(R.drawable.renard4);
                partie.add(R.drawable.renard5);
                partie.add(R.drawable.renard6);
                break;
            case "Renne":
                partie.add(R.drawable.renne1);
                partie.add(R.drawable.renne2);
                partie.add(R.drawable.renne3);
                partie.add(R.drawable.renne4);
                partie.add(R.drawable.renne5);
                break;
            case "Singe":
                partie.add(R.drawable.singe1);
                partie.add(R.drawable.singe2);
                partie.add(R.drawable.singe3);
                partie.add(R.drawable.singe4);
                partie.add(R.drawable.singe5);
                break;
            case "Tigre":
                partie.add(R.drawable.tigre1);
                partie.add(R.drawable.tigre2);
                partie.add(R.drawable.tigre3);
                partie.add(R.drawable.tigre4);
                partie.add(R.drawable.tigre5);
                break;
            case "Tortue":
                partie.add(R.drawable.tortue1);
                partie.add(R.drawable.tortue2);
                partie.add(R.drawable.tortue3);
                partie.add(R.drawable.tortue4);
                partie.add(R.drawable.tortue5);
                partie.add(R.drawable.tortue6);
                break;
            case "Vache":
                partie.add(R.drawable.vache1);
                partie.add(R.drawable.vache2);
                partie.add(R.drawable.vache3);
                partie.add(R.drawable.vache4);
                partie.add(R.drawable.vache5);
                break;
            case "Zebre":
                partie.add(R.drawable.zebre1);
                partie.add(R.drawable.zebre2);
                partie.add(R.drawable.zebre3);
                partie.add(R.drawable.zebre4);
                partie.add(R.drawable.zebre5);
                break;

        }

    }

    public char GetLettres(int index){
        return lettres.get(index);
    }

    public int GetLongueur(){
        return nom.length();
    }



}
