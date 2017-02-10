/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import java.util.Random;

/**
 * Tetromino-luokka määrittelee erimuotoiset Tetris-palat eli tetrominot
 *
 * @author salmisar
 */
public class Tetromino {

    private int[][] tetromino;
    private int muoto;
    private static int[][][] tetrominot // Taulukko, joka sisältää erimuotoisten tetrominojen koordinaatit
            = // IPala (0)
            {{{0, 0}, {0, 1}, {0, 2}, {0, -1}},
             // KuutioPala (1)
             {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
             // SPala (2)
             {{0, 0}, {1, 0}, {1, 1}, {0, -1}},
             // ZPala (3)
             {{0, 0}, {1, 0}, {0, 1}, {1, -1}},
             // TPala (4)
             {{0, 0}, {1, 0}, {0, 1}, {-1, 0}},
             // LPala (5)
             {{0, 0}, {0, -1}, {0, 1}, {1, -1}},
             // JPala (6)
             {{0, 0}, {0, -1}, {0, 1}, {-1, -1}},
            // TyhjaPala (7)
             {{0, 0}, {0, 0}, {0, 0}, {0, 0}}};

    /**
     * Konstruktori luo uuden satunnaisen tetrominon
     */
    public Tetromino() {
        this.tetromino = new int[4][2];
        this.muoto = satunnainenMuoto();
        this.tetromino = tetrominot[this.muoto];
    }

    /**
     * Konstruktori luo uuden halutunlaisen tetrominon
     *
     * @param muoto Haluttu muoto (taulukosta) integer-arvona
     */
    public Tetromino(int muoto) {
        tetromino = new int[4][2];
        this.muoto = muoto;
        tetromino = tetrominot[this.muoto];
    }

    public int[][] getTetromino() {
        return this.tetromino;
    }

    public static int[][] getTetromino(int muoto) {
        return tetrominot[muoto];
    }

    public int getMuoto() {
        return this.muoto;
    }

    /**
     * Metodi päivittää taulukon vastaamaan tetrominon seuraavaa käännöstä
     *
     * @return Taulukko, jossa on käännetyn tetrominon uudet koordinaatit
     */
    public int[][] seuraavaKaannos() {
        if (this.muoto == 1) {
            return this.tetromino;
        }

        int[][] tulos = new int[4][2];
        for (int i = 0; i < 4; i++) {
            tulos[i][0] = this.tetromino[i][1];
            tulos[i][1] = -this.tetromino[i][0];
        }

        return tulos;
    }

    /**
     * Päivittää tetrominotaulukon aina kukin käännoksen jälkeen vastaamaan
     * tetrominon tilaa
     *
     * @see fi.mamelukki.logiikka.Tetromino#seuraavaKaannos()
     */
    public void kaanna() {
        this.tetromino = this.seuraavaKaannos();
    }

    private int satunnainenMuoto() {
        Random muodonArpoja = new Random();
        return muodonArpoja.nextInt(7);
    }
}
