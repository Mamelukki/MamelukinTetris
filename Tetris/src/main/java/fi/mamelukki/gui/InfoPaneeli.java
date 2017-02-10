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
 * InfoPaneeli-luokka luo "status-paneelin", joka näyttää seuraavan tetrominon ja käyttäjän pisteet
 * 
 * @author salmisar
 */
public class InfoPaneeli extends JPanel {

    private static int rivit;
    private static int[][] seuraavaPala;

    /**
     * Konstruktori luo InfoPaneelin, jossa näkyy seuraava tetromino ja pelaajan pisteet
     * 
     */
    public InfoPaneeli() {
        this.setPreferredSize(new Dimension(100, 400));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.rivit = 0;
        this.seuraavaPala = Tetromino.getTetromino(Pelilauta.getSeuraavaMuoto());
        JLabel seuraava = new JLabel("Seuraava");
        JLabel rivitTekstina = new JLabel("Rivit");
        add(seuraava);
        add(Box.createRigidArea(new Dimension(30, 200)));
        add(rivitTekstina);
    }

    /**
     * Piirtää InfoPaneelin elementit
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
        g.drawString(Integer.toString(this.rivit), 30, 250);
    }

    /**
     * Metodi kasvattaa pelaajan pisteitä täysien (poistettujen) rivien mukaan
     *
     * @param pisteet Pisteet täysien (poistettujen) rivien mukaan
     */
    public static void kasvataRiveja(int pisteet) {
        InfoPaneeli.rivit = InfoPaneeli.rivit + pisteet;
    }
    
    public void getSeuraavaPala() {
        this.seuraavaPala = Tetromino.getTetromino(Pelilauta.getSeuraavaMuoto());
    }
}
