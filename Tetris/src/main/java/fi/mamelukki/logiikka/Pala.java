/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import java.awt.Color;

/**
 *
 * @author salmisar
 */
public class Pala {

    private int x;
    private int y;
    private Color vari;

    public Pala(int x, int y, Color vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    public void liiku(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getVari() {
        return vari;
    }
    
    public void setVari(Color vari) {
        this.vari = vari;
    }
    
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    } 
}
