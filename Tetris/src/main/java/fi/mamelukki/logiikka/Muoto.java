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
    
    public void setSatunnainenMuoto() {
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % 7 + 1;
        Tetrominot[] values = Tetrominot.values(); 
        setMuoto(values[x]);
    }
}
