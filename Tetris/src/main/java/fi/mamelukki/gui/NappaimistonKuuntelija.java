/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * NäppimistonKuuntelija rekisteröi käyttäjältä saadun syötteen ja kutsuu
 * Tetris-luokan metodeja niiden toteuttamiseen
 *
 * @see fi.mamelukki.gui.Tetris
 * 
 * @author salmisar
 */
public class NappaimistonKuuntelija extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_DOWN) {
            Tetris.liikuAlas();
        } else if (keys == KeyEvent.VK_LEFT) {
            Tetris.liikuVasemmalle();
        } else if (keys == KeyEvent.VK_RIGHT) {
            Tetris.liikuOikealle();
        } else if (keys == KeyEvent.VK_UP) {
            Tetris.kaanna();
        }
    }

}
