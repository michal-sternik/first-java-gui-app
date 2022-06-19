package Observable;

import Observers.Obserwator;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Kolor implements Subject {

    private int red, green, blue;
    ArrayList<Obserwator> obserwatorzy = new ArrayList<>();
    private String kodKoloru;
    private Color color;

    Random random = new Random();
    public Kolor(){
        this.red = random.nextInt(256);
        this.green = random.nextInt(256);
        this.blue = random.nextInt(256);
        color = new Color(this.red, this.green, this.blue);
    }
    public String getKodKoloru(){
        return kodKoloru;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public Color getColor() {
        return color;
    }

    public void zarejestrujOdbiorce(Obserwator o) {
        obserwatorzy.add(o);
    }

    public void wyrejestrujOdbiorce(Obserwator o) {
        obserwatorzy.remove(o);
    }

    public void powiadomOZmianie() {
        for (int i = 0; i < obserwatorzy.size(); i++) {
            obserwatorzy.get(i).update(red, green, blue);
        }
    }
    public void zmienKolor(){
        this.red = random.nextInt(256);
        this.green = random.nextInt(256);
        this.blue = random.nextInt(256);
        color = new Color(this.red, this.green, this.blue);
        kodKoloru = "("+red+", "+green+", "+blue+")";
        powiadomOZmianie();
    }
}
