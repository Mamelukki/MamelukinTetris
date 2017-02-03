/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author salmisar
 */
public class Muoto {

    private Tetrominot palanMuoto;
    private int[][] koordinaatit;

    public Muoto() {
        this.koordinaatit = new int[4][2];
        setMuoto(Tetrominot.TyhjaPala);
    }

    public void setMuoto(Tetrominot muoto) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                this.koordinaatit[i][j] = this.palanMuoto.koordinaatit[i][j];
            }
        }

        this.palanMuoto = muoto;
    }

    public void setSatunnainenMuoto() {
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % 7 + 1; // Valitaan satunnaisesti jokin Tetromino
        Tetrominot[] values = Tetrominot.values();
        setMuoto(values[x]);
    }

    public int getX(int indeksi) {
        return this.koordinaatit[indeksi][0];
    }

    public int getY(int indeksi) {
        return this.koordinaatit[indeksi][1];
    }

    public void setX(int indeksi, int x) {
        this.koordinaatit[indeksi][0] = x;
    }

    public void setY(int indeksi, int y) {
        this.koordinaatit[indeksi][1] = y;
    }

    public Tetrominot getPalanMuoto() {
        return this.palanMuoto;
    }

    public int minX() {
        int minimi = this.koordinaatit[0][0];
        
        for (int i = 0; i < 4; i++) {
            minimi = Math.min(minimi, koordinaatit[i][0]);
        }
        return minimi;
    }

    public int minY() {
        int minimi = this.koordinaatit[0][1];
        
        for (int i = 0; i < 4; i++) {
            minimi = Math.min(minimi, this.koordinaatit[i][1]);
        }
        return minimi;
    }

    public Muoto kaannaVasemmalle() {
        if (this.palanMuoto == Tetrominot.KuutioPala) { // Jos pala on kuutio, sitä ei tarvitse kääntää, joten palautetaan tämänhetkinen muoto
            return this;
        }

        Muoto uusiMuoto = new Muoto();
        uusiMuoto.setMuoto(this.palanMuoto);

        for (int i = 0; i < 4; ++i) {
            uusiMuoto.setX(i, getY(i));
            uusiMuoto.setY(i, -getX(i));
        }

        return uusiMuoto;
    }

    public Muoto kaannaOikealle() {
        if (this.palanMuoto == Tetrominot.KuutioPala) { // Jos pala on kuutio, sitä ei tarvitse kääntää, joten palautetaan tämänhetkinen muoto
            return this;
        }

        Muoto uusiMuoto = new Muoto();
        uusiMuoto.palanMuoto = this.palanMuoto;

        for (int i = 0; i < 4; ++i) {
            uusiMuoto.setX(i, -getY(i));
            uusiMuoto.setY(i, getX(i));
        }

        return uusiMuoto;
    }
}
