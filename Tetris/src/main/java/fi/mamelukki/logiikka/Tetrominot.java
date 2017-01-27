/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

/**
 *
 * @author salmisar
 */
public enum Tetrominot {

    TyhjaPala(new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
    IPala(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, -1}}),
    TPala(new int[][]{{0, 0}, {1, 0}, {0, 1}, {-1, 0}}),
    SPala(new int[][]{{0, 0}, {1, 0}, {1, 1}, {0, -1}}),
    ZPala(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, -1}}),
    JPala(new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, -1}}),
    LPala(new int[][]{{0, 0}, {0, -1}, {0, 1}, {1, -1}}),
    KuutioPala(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}});

    public int[][] koordinaatit; // Tetrominojen koordinaatit

    private Tetrominot(int[][] koordinaatit) {
        this.koordinaatit = koordinaatit;
    }
}
