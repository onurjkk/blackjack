package com.blackjack;


import java.util.Collections;
import java.util.ArrayList;

public class Mazzo {

    private ArrayList<Carta> carte;

    public Mazzo() {
        carte = new ArrayList<>();
        
        String[] semi = {"cuori","quadri","fiori","picche"};
        String[] ranghi = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] valori = {2,3,4,5,6,7,8,9,10,10,10,10,11};
        
        for(String seme: semi) {
            for(int i=0; i<ranghi.length; i++) {
                carte.add(new Carta(seme,ranghi[i],valori[i]));
            }
        }
        Collections.shuffle(carte);
    }

    public Carta getCarta() {
        return carte.remove(0);
    }
}
