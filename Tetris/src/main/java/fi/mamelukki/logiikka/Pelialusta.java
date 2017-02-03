/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import fi.mamelukki.logiikka.Muoto;
import fi.mamelukki.logiikka.Tetrominot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author salmisar
 */
// Pelialusta sisältää oleellisen pelilogiikan, esimerkiksi uusien palojen luomisen ja rivien tyhjentämisen

public class Pelialusta extends JPanel {

    private static final int leveys = 10;
    private static final int korkeus = 20; // Peli on kooltaan klassinen 10 x 20
    private boolean onkoPausella = false; // Tarkistaa, onko peli pausella
    private boolean onkoAloitettu = false; // Tarkistaa, onko peli käynnissä
    private boolean onkoPudonnut = false; // Selvittää, pitääkö luoda uusi pala
    private JLabel statusBar; // Ilmoittaa pisteet yms.
    private Muoto muoto;
    private Tetrominot[] pelialusta;
    int poistetutRivit = 0;
    int x = 0;
    int y = 0;

    public Pelialusta(Tetris tetris) {
        setFocusable(true);
        this.muoto = new Muoto();
        this.statusBar = tetris.getStatusBar();
        this.pelialusta = new Tetrominot[this.leveys * this.korkeus];
        tyhjennaPelialusta();
    }

    public void aloita() {
        if (onkoPausella) {
            return;
        }

        onkoAloitettu = true;
        poistetutRivit = 0;
        tyhjennaPelialusta();
        luoUusiPala();
    }

    public void pause() {
        if (!onkoAloitettu) {
            return;
        }

        onkoPausella = !onkoPausella;

        if (onkoPausella) {
            statusBar.setText("Peli on pausella");
        } else {
            statusBar.setText(String.valueOf(poistetutRivit));
        }

        repaint();
    }

    public Tetrominot muotoKohdassa(int x, int y) {
        return this.pelialusta[(y * this.leveys) + x];
    }

    public void tyhjennaPelialusta() {
        for (int i = 0; i < this.leveys * this.korkeus; i++) { // Tyhjennetään koko pelialusta laskemalla pinta-ala ja muuttamalla kaiken tyhjiksi Tetrominoiksi
            this.pelialusta[i] = Tetrominot.TyhjaPala;
        }
    }

    public void pudotaPala() {
        int uusiY = this.y;
        while (uusiY > 0) {
            if (!yritaSiirtaa(this.muoto, this.x, this.y - 1)) { 
                break;
            }
            uusiY--;
        }
        onkoPalaPudotettu();
    }

    public boolean onkoPalaPudotettu() {
        if (!yritaSiirtaa(this.muoto, this.x, this.y - 1)) {
            onkoPudonnut = true;
        }
        
        return onkoPudonnut = false;
    }

    public void tyhjennaRivi() {
        int taydetRivit = 0;

        for (int i = this.korkeus - 1; i >= 0; --i) {
            boolean onkoRiviTaynna = true;

            for (int j = 0; j < this.leveys; ++j) {
                if (muotoKohdassa(j, i) == Tetrominot.TyhjaPala) {
                    onkoRiviTaynna = false;
                    break;
                }
            }

            if (onkoRiviTaynna = true) {
                taydetRivit++;

                for (int k = i; k < this.korkeus - 1; ++k) {
                    for (int j = 0; j < this.leveys; ++j) {
                        this.pelialusta[(k * this.leveys) + j] = muotoKohdassa(j, k + 1);
                    }
                }
            }
        }

        if (taydetRivit > 0) {
            this.poistetutRivit = this.poistetutRivit + taydetRivit;
            this.statusBar.setText(String.valueOf(this.poistetutRivit));
            onkoPudonnut = true;
            this.muoto.setMuoto(Tetrominot.TyhjaPala);
            repaint();
        }
    }

    public void luoUusiPala() {
        this.muoto.setSatunnainenMuoto();
        this.x = this.leveys / 2 + 1;
        this.y = this.korkeus - 1 + this.muoto.minY();

        if (!yritaSiirtaa(this.muoto, this.x, this.y)) {
            this.muoto.setMuoto(Tetrominot.TyhjaPala);
            onkoAloitettu = false;
            statusBar.setText("Hävisit, peli loppu!");
        }
    }

    public boolean yritaSiirtaa(Muoto uusiPala, int uusiX, int uusiY) {
        for (int i = 0; i < 4; ++i) {
            int x = uusiX + uusiPala.getX(i);
            int y = uusiY - uusiPala.getY(i);
            if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus) { // Tarkistetaan, onko x ja y pelialustan ulkopuolella ja jos on, palautetaan false
                return false;
            }
            if (muotoKohdassa(x, y) != Tetrominot.TyhjaPala) { 
                return false;
            }
        }

        this.muoto = uusiPala;
        this.x = uusiX;
        this.y = uusiY;

        repaint();
        return true; // Jos siirto on mahdollinen, palautetaan true
    }

}

