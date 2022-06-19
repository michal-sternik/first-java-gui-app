package Observers;

import Observable.Subject;

import java.awt.*;

public class Green implements Obserwator {

    int green;
    private String kodKoloru;
    private Color color;

    public Green(Subject kolor){
        kolor.zarejestrujOdbiorce(this);
    }

    public void update(int red, int green, int blue) {
        this.green = green;
        zmienKolor();
    }
    public void zmienKolor(){
        color = new Color(0,green,0);
        kodKoloru = "("+0+", "+green+", "+0+")";
    }
    public Color getColor() {
        return color;
    }
    public String getKodKoloru(){
        return kodKoloru;
    }
}