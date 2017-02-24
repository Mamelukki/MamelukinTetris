/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.gui;

import fi.mamelukki.logiikka.Pelilauta;
import fi.mamelukki.logiikka.PelinKulku;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Tetris on main class, joka käynnistää ohjelman. Tämä luokka toteuttaa myös
 * PelinKulku-luokan abstraktit metodit ja hyödyntää NäppäimistönKuuntelijaa
 * pelikomentojen toteuttamiseen.
 *
 * @author salmisar
 */
public class Tetris extends PelinKulku implements ActionListener {

    public static Pelilauta pelilauta;
    public static InfoPaneeli infoPaneeli;
    public static NappaimistonKuuntelija nappaimistonKuuntelija;
    public static JFrame ikkuna;
    public static Container sisalto;

    /**
     * Main-luokka, joka luo uuden Tetris-pelin.
     * @param args Argumentit
     */
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.run(1.3);
    }

    /**
     * Kutsuu siirraAlas-metodia luokasta Pelilauta.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#siirraAlas()
     */
    public static void liikuAlas() {
        pelilauta.siirraAlas();
    }

    /**
     * Kutsuu siirraVasemmalle-metodia luokasta Pelilauta.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#siirraVasemmalle()
     */
    public static void liikuVasemmalle() {
        pelilauta.siirraVasemmalle();
    }

    /**
     * Kutsuu siirraOikealle-metodia luokasta Pelilauta.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#siirraOikealle()
     */
    public static void liikuOikealle() {
        pelilauta.siirraOikealle();
    }

    /**
     * Kutsuu kaanna-metodia luokasta Pelilauta.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#kaanna()
     */
    public static void kaanna() {
        pelilauta.kaanna();
    }

    /**
     * Metodi käynnistää pelin.
     *
     * @see fi.mamelukki.Pelilauta#Pelilauta()
     */
    @Override
    public void kaynnista() {
        pelilauta = new Pelilauta();
        pelilauta.setBackground(Color.BLACK);
        pelilauta.merkitseTetromino();
        infoPaneeli = new InfoPaneeli();
        nappaimistonKuuntelija = new NappaimistonKuuntelija();
        ikkuna = new JFrame("Tetris");
        ikkuna.setSize(300, 400);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.add(pelilauta, BorderLayout.EAST);
        ikkuna.add(infoPaneeli, BorderLayout.WEST);
        ikkuna.addKeyListener(nappaimistonKuuntelija);
        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    @Override
    public void sammuta() {
        pysayta();
    }

    /**
     * Päivittää pelin päivittämällä pelilaudan tilan.
     *
     * @see fi.mamelukki.logiikka.Pelilauta#siirraAlas()
     */
    @Override
    public void paivita() {
        pelilauta.siirraAlas();
        infoPaneeli.getSeuraavaPala();
    }

    @Override
    public void piirra() {
        pelilauta.repaint();
        infoPaneeli.repaint();
    }

    /**
     * Metodi toimii käyttäjältä saadun syötteen mukaan.
     *
     * @param e NappaimistonKuuntelijalta saatu komento
     *
     * @see fi.mamelukki.gui.NappaimistonKuuntelija
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pelilauta.repaint();
        piirra();
    }
}
