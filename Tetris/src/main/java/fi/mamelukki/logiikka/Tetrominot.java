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

// Sisältää erilaiset Tetris-palat eli Tetrominot ja niiden koordinaatit ja värit

public enum Tetrominot {

    TyhjaPala(new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}, new Color(0, 0, 0)),
    IPala(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, -1}}, new Color(0, 255, 51)),
    TPala(new int[][]{{0, 0}, {1, 0}, {0, 1}, {-1, 0}}, new Color(255, 102, 102)),
    SPala(new int[][]{{0, 0}, {1, 0}, {1, 1}, {0, -1}}, new Color(51, 153, 255)),
    ZPala(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, -1}}, new Color(255, 204, 0)),
    JPala(new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, -1}}, new Color(255, 255, 153)),
    LPala(new int[][]{{0, 0}, {0, -1}, {0, 1}, {1, -1}}, new Color(10, 0, 255)),
    KuutioPala(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, new Color(255, 102, 0));

    public int[][] koordinaatit; // Tetrominojen koordinaatit
    public Color vari;

    private Tetrominot(int[][] koordinaatit, Color vari) {
        this.koordinaatit = koordinaatit;
        this.vari = vari;
    }
}
