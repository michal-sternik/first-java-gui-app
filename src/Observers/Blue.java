package Observers;

import Observable.Subject;

import java.awt.*;

public class Blue implements Obserwator {

    int blue;
    private String kodKoloru;
    private Color color;

    public Blue(Subject kolor){
        kolor.zarejestrujOdbiorce(this);
    }

    public void update(int red, int green, int blue) {
        this.blue = blue;
        zmienKolor();
    }
    public void zmienKolor(){
        color = new Color(0,0,blue);
        kodKoloru = "("+0+", "+0+", "+blue+")";
    }
    public Color getColor() {
        return color;
    }
    public String getKodKoloru(){
        return kodKoloru;
    }
}