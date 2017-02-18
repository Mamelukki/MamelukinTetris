/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.gui;

import fi.mamelukki.logiikka.Pelilauta;
import fi.mamelukki.logiikka.Tetromino;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * InfoPaneeli-luokka luo "status-paneelin", joka näyttää seuraavan tetrominon,
 * poistetut (täydet) rivit ja käyttäjän pisteet.
 *
 * @author salmisar
 */
public class InfoPaneeli extends JPanel {

    private static int rivit;
    private static int pisteet;
    private static int[][] seuraavaPala;

    /**
     * Konstruktori luo InfoPaneelin, jossa näkyy seuraava tetromino, poistetut
     * (täydet) rivit ja pelaajan pisteet.
     *
     */
    public InfoPaneeli() {
        this.setPreferredSize(new Dimension(90, 400));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.rivit = 0;
        this.pisteet = 0;
        this.seuraavaPala = Tetromino.getTetromino(Pelilauta.getSeuraavaMuoto());
        JLabel seuraava = new JLabel("Seuraava");
        JLabel rivitTekstina = new JLabel("Rivit");
        JLabel pisteetTekstina = new JLabel("Pisteet");
        add(seuraava);
        add(Box.createRigidArea(new Dimension(30, 130)));
        add(rivitTekstina);
        add(Box.createRigidArea(new Dimension(30, 80)));
        add(pisteetTekstina);
    }

    /**
     * Piirtää InfoPaneelin elementit.
     *
     * @param g Käytettävä Graphics-työkalu
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            g.fillRect(30 + 20 * this.seuraavaPala[i][0], 50 + 20 * this.seuraavaPala[i][1], 20, 20);
        }
        g.drawString(Integer.toString(this.rivit), 30, 200);
        g.drawString(Integer.toString(this.pisteet), 30, 300);
    }

    /**
     * Metodi kasvattaa riveja täysien (poistettujen) rivien mukaan.
     *
     * @param rivit Rivien määrä täysien (poistettujen) rivien mukaan
     */
    public static void kasvataRiveja(int rivit) {
        InfoPaneeli.rivit = InfoPaneeli.rivit + rivit;
    }

    /**
     * Metodi kasvattaa pisteita parametrina annettujen pisteiden mukaan
     * (pisteet kasvavat vakionopeudella).
     *
     * @param pisteet Pisteet täysien (poistettujen) rivien mukaan
     */
    public static void kasvataPisteita(int pisteet) {
        InfoPaneeli.pisteet = InfoPaneeli.pisteet + pisteet;
    }

    /**
     * Metodi palauttaa seuraavan palan.
     */
    public void getSeuraavaPala() {
        this.seuraavaPala = Tetromino.getTetromino(Pelilauta.getSeuraavaMuoto());
    }
}
