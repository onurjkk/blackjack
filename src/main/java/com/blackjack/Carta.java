package com.blackjack;

public class Carta {

    private int valore;
    private String seme;

    public Carta(String seme, int valore) {
        this.seme = seme;
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public String getSeme() {
        return seme;
    }

    public void setSeme(String seme) {
        this.seme = seme;
    }

    @Override
    public String toString() {
        return "Carta{seme=" + seme + ",valore=" + valore + "}";
    }
}