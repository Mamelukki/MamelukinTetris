/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import fi.mamelukki.gui.InfoPaneeli;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Pelilauta-luokka luo pelilaudan Tetris-peliin. Luokka sisältää oleellisen
 * pelilogiikan, esimerkiksi rivien tyhjentämisen ja uuden palan luomisen.
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
     * Konstruktori luo pelilaudan ja ensimmäisen tetrominon.
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
     * Metodi piirtää pelilaudan ja sen elementit.
     *
     * @param g Käytettävä Graphics-työkalu
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < 20; y++) {
            for (int x = 1; x < 11; x++) {
                if (this.pelilauta[y][x] != 0) {
                    g.setColor(Color.ORANGE);
                    g.fillRect((x - 1) * 20, y * 20, 20, 20);
                    g.setColor(new Color(253, 235, 59));
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

    /**
     * Metodi merkitsee aktiivisen tetrominon pelilaudalle, mutta ei vielä
     * piirrä sitä.
     */
    public void merkitseTetromino() {
        int[][] temp = this.pala.getTetromino();
        int muoto = this.pala.getMuoto();

        if (muoto == 7) { // Jos tetromino on tyhja, ei tarvitse tehdä mitään
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.pelilauta[this.y + temp[i][1]][this.x + temp[i][0]] = muoto + 1;
        }
    }

    /**
     * Metodi poistaa aktiivisen tetrominon pelilaudalta.
     */
    public void poistaTetromino() {
        int[][] temp = this.pala.getTetromino();
        for (int i = 0; i < 4; i++) {
            this.pelilauta[this.y + temp[i][1]][this.x + temp[i][0]] = 0;
        }
    }

    /**
     * Metodi Tarkistaa onko pelilaudalla tilaa tetrominolle.
     *
     * @param uudetPisteet tetrominon tarkastettavat koordinaatit
     * @param tarkastettavaX tarkastettava x-akselin arvo
     * @param tarkastettavaY tarkastettava y-akselin arvo
     * @return boolean-arvo, joka määrittää, onko tilaa vai ei
     */
    public boolean onkoTilaa(int[][] uudetPisteet, int tarkastettavaX, int tarkastettavaY) {
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

    /**
     * Metodi siirtää aktiivisen tetrominon yhden askeleen alemmas.
     *
     * @return Aktiivinen tetromino
     * @see fi.mamelukki.logiikka.Pelilauta#vapautaTetromino()
     */
    public Tetromino siirraAlas() {
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

    /**
     * Metodi siirtää aktiivisen tetrominon yhden askeleen vasemmalle.
     *
     * @return Aktiivinen tetromino
     */
    public Tetromino siirraVasemmalle() {
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

    /**
     * Metodi siirtää aktiivisen tetrominon yhden askeleen oikealle.
     *
     * @return Aktiivinen tetromino
     */
    public Tetromino siirraOikealle() {
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

    /**
     * Metodi kääntää aktiivisen tetrominon, mikäli sille on tilaa.
     *
     * @see fi.mamelukki.logiikka.Tetromino#seuraavaKaannoos()
     * @see fi.mamelukki.logiikka.Tetromino#kaanna()
     */
    public void kaanna() {
        if (this.onkoTilaa(this.pala.seuraavaKaannos(), this.x, this.y)) {
            poistaTetromino();
            this.pala.kaanna();
            merkitseTetromino();
            repaint();
        }
    }

    /**
     * Metodi palauttaa pelilaudan merkkijonona. Metodia on hyödynnetty
     * esimerkiksi testauksessa.
     *
     * @return Pelilaudan tila merkkijonona
     */
    public String tulostaPelilauta() {
        String tulos = "";
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 11; j++) {
                tulos += this.pelilauta[i][j];
            }
            tulos += "\n";
        }
        return tulos;
    }

    /**
     * Metodi vapauttaa aktiivisen tetrominon ja luo tilalle uuden.
     *
     * @return Uusi aktiivinen tetromino
     *
     * @see fi.mamelukki.logiikka.Tetromino#Tetromino(int)
     * @see fi.mamelukki.logiikka.Pelilauta#tarkistaRivit()
     */
    private Tetromino vapautaTetromino() {
        tarkistaRivit();
        this.y = 1;
        this.x = 4;
        this.pala = new Tetromino(seuraavaPala);
        this.seuraavaPala = random.nextInt(7);
        tarkistaOnkoPeliOhi();
        return this.pala;
    }

    /**
     * Metodi tarkistaa täydet rivit. Kun täydet rivit on löydetty, metodi
     * tyhjentää rivit.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#tyhjennaRivit(int[])
     */
    private void tarkistaRivit() {
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

    /**
     * Metodi poistaa täydet rivit pelilaudalta.
     *
     * @param taydetRivit Taulukko, joka sisältää täytetyt rivit
     *
     * @see fi.mamelukki.logiikka.Pelilauta#pudotaRivit(int[])
     */
    private void tyhjennaRivit(int[] taydetRivit) {
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

    /**
     * Metodi pudottaa kaikki mahdolliset rivit alaspäin sen jälkeen, kun jokin
     * rivi on tyhjennetty. Metodi kasvattaa myös infopaneelin pisteitä ja
     * rivejä.
     *
     * @param taydetRivit Taulukko, joka sisältää täytetyt rivit
     *
     * @see fi.mamelukki.gui.InfoPaneeli#kasvataRiveja(int)
     * @see fi.mamelukki.gui.InfoPaneeli#kasvataPisteita(int)
     */
    private void pudotaRivit(int[] taydetRivit) {
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

        InfoPaneeli.kasvataRiveja(valmiitRivit);
        InfoPaneeli.kasvataPisteita(valmiitRivit * 10);
        repaint();
    }

    /**
     * Metodi tarkistaa, mahtuuko syntyvä tetromino sen aloituspaikkaan. Mikäli
     * tetromino ei mahdu pelilaudalle, metodi kutsuu peliOhi-metodia.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#peliOhi()
     */
    private void tarkistaOnkoPeliOhi() {
        int[][] uudetPisteet = pala.getTetromino();
        for (int i = 0; i < 4; i++) {
            if (pelilauta[y + uudetPisteet[i][1]][x + uudetPisteet[i][0]] != 0) {
                peliOhi();
            }
        }
    }

    /**
     * Metodi sulkee pelin.
     */
    private void peliOhi() {
        System.exit(0);
    }
}
