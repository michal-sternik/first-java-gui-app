
import Observable.Kolor;
import Observers.Blue;
import Observers.Green;
import Observers.Red;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project {
    JFrame ramka;
    JPanel main;
    JPanel rgb;
    JPanel kolorGlowny;
    JPanel panelNaPrzycisk;
    JPanel red;
    JPanel green;
    JPanel blue;
    JLabel infoOKolorzeMain;
    JLabel infoOKolorzeRed;
    JLabel infoOKolorzeGreen;
    JLabel infoOKolorzeBlue;
    JPanel naWstep;
    JLabel wstep;
    JButton button;


    public static void main(String[] args) {
        Project GUI = new Project();
        GUI.start();

    }
    public void start() {
        //tworzę szkielet programu (3 wiersze; 1 na 3 składowe kolory, 2 na kolor główny, 3 na przycisk do zmiany kolorów
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setVisible(true);
        ramka.setSize(500, 500);

        //wstep
        wstep = new JLabel("Witaj w rozdzielaczu kolorów!");
        naWstep = new JPanel();
        ramka.getContentPane().add(BorderLayout.NORTH,naWstep);
        naWstep.add(wstep);
        wstep.setFont(new Font(wstep.getName(),Font.BOLD,25));
        naWstep.setBackground(Color.gray);
        naWstep.setBorder(BorderFactory.createMatteBorder(5,5,0,5,Color.BLACK));


        main = new JPanel();
        ramka.getContentPane().add(BorderLayout.CENTER,main);
        rgb = new JPanel();
        kolorGlowny = new JPanel();
        panelNaPrzycisk = new JPanel();


        GridLayout gL = new GridLayout(3, 1, 0, 0);
        main.setLayout(gL);
        main.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        main.add(rgb);
        main.add(kolorGlowny);
        main.add(panelNaPrzycisk);

        panelNaPrzycisk.setBackground(Color.GREEN);

        //tutaj na skladowe
        kolorGlowny.setBorder(BorderFactory.createMatteBorder(5,0,5,0,Color.BLACK));


        red = new JPanel();
        green = new JPanel();
        blue = new JPanel();
        GridLayout gLRGB = new GridLayout(1, 3);

        rgb.setLayout(gLRGB);
        rgb.add(red);
        rgb.add(green);
        rgb.add(blue);
        green.setBorder(BorderFactory.createMatteBorder(0,5,0,5,Color.BLACK));
        infoOKolorzeRed = new JLabel();
        infoOKolorzeGreen = new JLabel();
        infoOKolorzeBlue = new JLabel();

        red.add(infoOKolorzeRed);
        green.add(infoOKolorzeGreen);
        blue.add(infoOKolorzeBlue);

        red.setBackground(Color.RED);
        green.setBackground(Color.GREEN);
        blue.setBackground(Color.BLUE);

        //panel środkowy (dla obserwowanego)
        infoOKolorzeMain = new JLabel();
        kolorGlowny.add(infoOKolorzeMain);

        //najnizszy panel
        GridLayout gLPrzycisk = new GridLayout(1, 3);
        panelNaPrzycisk.setLayout(gLPrzycisk);
        JPanel panelpusty1 = new JPanel();
        JPanel panelZPrzycisk = new JPanel();
        JPanel panelpusty3 = new JPanel();
        button = new JButton("Klikaj");
        button.addActionListener(new KolorListener());
        panelNaPrzycisk.add(panelpusty1);
        panelpusty1.setBackground(Color.gray);
        panelNaPrzycisk.add(button);
        panelpusty3.setBackground(Color.gray);
        panelNaPrzycisk.add(panelpusty3);
        //panelZPrzycisk.add(button);
        button.setVisible(true);
    }
        class KolorListener implements ActionListener {
            Kolor kolor;
            Red redObserver;
            Green greenObserver;
            Blue blueObserver;
            public void actionPerformed(ActionEvent e) {
                kolor = new Kolor();
                redObserver = new Red(kolor);
                greenObserver = new Green(kolor);
                blueObserver = new Blue(kolor);
                kolor.zmienKolor();
                kolorGlowny.setBackground(kolor.getColor());
                red.setBackground(redObserver.getColor());
                green.setBackground(greenObserver.getColor());
                blue.setBackground(blueObserver.getColor());
                infoOKolorzeMain.setText(kolor.getKodKoloru());
                infoOKolorzeRed.setText(redObserver.getKodKoloru());
                infoOKolorzeGreen.setText(greenObserver.getKodKoloru());
                infoOKolorzeBlue.setText(blueObserver.getKodKoloru());
                button.setBorder(BorderFactory.createMatteBorder(15,15,15,15,kolor.getColor()));


            }
        }
}

