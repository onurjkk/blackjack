package com.blackjack;


import java.util.Collections;
import java.util.Stack;

public class Mazzo {

    static Stack<Carta> carte;

    public Mazzo() {
        carte = new Stack<>();
        for(int i=1; i<=13; i++) {
            carte.add(new Carta("cuori",i));
            carte.add(new Carta("fiori",i));
            carte.add(new Carta("picche",i));
            carte.add(new Carta("quadri",i));
        }
        shuffle();
    }

    public void reset() {
        carte = new Stack<>();
        for(int i=1; i<=13; i++) {
            carte.add(new Carta("cuori",i));
            carte.add(new Carta("fiori",i));
            carte.add(new Carta("picche",i));
            carte.add(new Carta("quadri",i));
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(carte);
    }

    public Carta getCarta() {
        return carte.pop();
    }

    @Override
    public String toString() {
        return carte+"";
    }

}
