package Observers;

import Observable.Subject;

import java.awt.*;

public class Red implements Obserwator {

    int red;
    private String kodKoloru;
    private Color color;

    public Red(Subject kolor){
        kolor.zarejestrujOdbiorce(this);
    }

    public void update(int red, int green, int blue) {
        this.red = red;
        zmienKolor();
    }

    public void zmienKolor(){
        color = new Color(red,0,0);
        kodKoloru = "("+red+", "+0+", "+0+")";
    }

    public Color getColor() {
        return color;
    }
    public String getKodKoloru(){
        return kodKoloru;
    }
}
