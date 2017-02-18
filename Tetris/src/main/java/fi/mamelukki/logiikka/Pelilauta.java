/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Pelilauta-luokka sisältää oleellisen pelilogiikan, esimerkiksi rivien
 * tyhjentämisen ja uuden palan luomisen 
 *
 * @author salmisar
 */
public class Pelilauta extends JPanel {

    public static Tetromino pala;
    public static int seuraavaPala;
    private static int pelilauta[][];
    private static int y;
    private static int x;
    private static Random random = new Random();

    /**
     * Konstruktori luo pelilaudan ja ensimmäisen tetrominon
     *
     * @see fi.mamelukki.logiikka.Tetromino#Tetromino()
     */
    public Pelilauta() {
        this.setPreferredSize(new Dimension(200, 400));
        this.pelilauta = new int[21][12];
        for (int i = 0; i < 21; i++) { // Pelilaudan koko on 10 x 20, reunoilla on yhdeksikköjä
            this.pelilauta[i][11] = this.pelilauta[i][0] = 9;
        }
        for (int i = 0; i < 12; i++) {
            this.pelilauta[20][i] = 9;
        }
        this.y = 1;
        this.x = 4;
        this.pala = new Tetromino();
        this.seuraavaPala = this.random.nextInt(7); // Arvotaan seuraava pala
    }

    /**
     * Piirtää pelilaudan ja sen elementit
     *
     * @param g Käytettävä Graphics-työkalu
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < 20; y++) {
            for (int x = 1; x < 11; x++) {
                if (this.pelilauta[y][x] != 0) {
                    g.setColor(new Color(93, 173, 226));
                    g.fillRect((x - 1) * 20, y * 20, 20, 20);
                    g.setColor(new Color(133, 193, 233));
                    g.fillRect(20 * (x - 1) + 1, 20 * y + 1, 18, 18);
                }
            }
        }
    }

    public int[][] getPelilauta() {
        return this.pelilauta;
    }

    public int getYArvo() {
        return this.y;
    }

    public int getXArvo() {
        return this.x;
    }

    public void setYArvo(int arvo) {
        this.y = arvo;
    }

    public void setXArvo(int arvo) {
        this.x = arvo;
    }

    public static int getSeuraavaMuoto() {
        return seuraavaPala;
    }

    public void merkitseTetromino() { // Merkitsee aktiivisen tetrominon pelilaudalle
        int[][] temp = this.pala.getTetromino();
        int muoto = this.pala.getMuoto();

        if (muoto == 7) { // Jos tetromino on tyhja, ei tarvitse tehdä mitään
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.pelilauta[this.y + temp[i][1]][this.x + temp[i][0]] = muoto + 1;
        }
    }

    public void poistaTetromino() { // Poistaa aktiivisen tetrominon pelilaudalta
        int[][] temp = this.pala.getTetromino();
        for (int i = 0; i < 4; i++) {
            this.pelilauta[this.y + temp[i][1]][this.x + temp[i][0]] = 0;
        }
    }

    public boolean onkoTilaa(int[][] uudetPisteet, int tarkastettavaX, int tarkastettavaY) { // Tarkistaa onko pelilaudalla tilaa tetrominolle
        boolean tulos = true;
        poistaTetromino();

        for (int i = 0; i < 4; i++) {
            if (this.pelilauta[tarkastettavaY + uudetPisteet[i][1]][tarkastettavaX + uudetPisteet[i][0]] != 0) {
                tulos = false;
            }
        }

        merkitseTetromino();
        return tulos;
    }

    public Tetromino siirraAlas() { // Siirtää tetrominon yhden "pykälän" alemmas
        if (this.pala == null) {
            return this.pala;
        }
        if (this.onkoTilaa(this.pala.getTetromino(), this.x, this.y + 1)) {
            poistaTetromino();
            this.y++;
            merkitseTetromino();
            repaint();
            return this.pala;
        } else {
            repaint();
            return vapautaTetromino();
        }
    }

    public Tetromino siirraVasemmalle() { // Siirtää tetrominon vasemmalle
        if (this.pala == null) {
            return this.pala;
        }
        if (this.onkoTilaa(this.pala.getTetromino(), this.x - 1, this.y)) {
            poistaTetromino();
            this.x--;
            merkitseTetromino();
            repaint();
            return this.pala;
        } else {
            return this.pala;
        }
    }

    public Tetromino siirraOikealle() { // Siirtää tetrominon oikealle 
        if (this.pala == null) {
            return this.pala;
        }
        if (this.onkoTilaa(this.pala.getTetromino(), this.x + 1, this.y)) {
            poistaTetromino();
            this.x++;
            merkitseTetromino();
            repaint();
            return this.pala;
        } else {
            return this.pala;
        }

    }

    public void kaanna() { // Kääntää tetrominon
        if (this.onkoTilaa(this.pala.seuraavaKaannos(), this.x, this.y)) { // Tarkistaa onko kääntämiseen tilaa
            poistaTetromino();
            this.pala.kaanna();
            merkitseTetromino();
            repaint();
        }
    }

    public String tulostaPelilauta() { // Tulostaa pelilaudan merkkijonona
        String tulos = "";
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 11; j++) {
                tulos += this.pelilauta[i][j];
            }
            tulos += "\n";
        }
        return tulos;
    }

    private Tetromino vapautaTetromino() { // Vapauttaa tetrominon ja luo uuden
        tarkistaRivit();
        this.y = 1;
        this.x = 4;
        this.pala = new Tetromino(seuraavaPala);
        this.seuraavaPala = random.nextInt(7);
        return this.pala;
    }

    private void tarkistaRivit() { // Tarkistaa täydet rivit
        int[] taydetRivit = new int[4];
        int indeksi = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 11; j++) {
                if (this.pelilauta[i][j] == 0) {
                    break;
                }
                if (j == 10) {
                    taydetRivit[indeksi] = i;
                    indeksi++;
                }
            }
        }
        tyhjennaRivit(taydetRivit);
    }

    private void tyhjennaRivit(int[] taydetRivit) { // Poistaa täydet rivit
        for (int i = 0; i < 4; i++) {
            if (taydetRivit[i] != 0) {
                for (int j = 1; j < 11; j++) {
                    this.pelilauta[taydetRivit[i]][j] = 0;
                }
            }
        }
        repaint();
        pudotaRivit(taydetRivit);
    }

    private void pudotaRivit(int[] taydetRivit) { // Pudottaa kaikki mahdolliset rivit alaspäin sen jälkeen, kun jokin rivi on tyhjennetty
        int valmiitRivit = 0;
        for (int i = 0; i < 4; i++) {
            if (taydetRivit[i] != 0) {
                valmiitRivit++;
                for (int j = taydetRivit[i]; j > 0; j--) {
                    for (int k = 1; k < 11; k++) {
                        this.pelilauta[j][k] = this.pelilauta[j - 1][k];
                    }
                }
            }
        }
    }
}
