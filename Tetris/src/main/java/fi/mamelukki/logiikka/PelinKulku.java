/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

/**
 * PelinKulku-luokka määrittää Tetris-pelin ajankulun ja tarjoaa abstraktit
 * metodit pelitilanteen käsittelyyn, esimerkiksi pelin sammuttamiseen.
 *
 * @author salmisar
 */
public abstract class PelinKulku {

    private boolean running = false;

    /**
     * Run-metodi määrittää pelin sisäisen ajankulun, peliaika on run-metodin
     * loopin suoritusaika.
     *
     * @param aikavali arvo (sekunteina), jonka välein peli päivittää peliajan
     */
    public void run(double aikavali) {
        running = true;

        kaynnista();
        double seuraavaAika = (double) System.nanoTime() / 1000000000.0;
        double maxAikaero = 0.5;
        int skipatutIkkunat = 1;
        int maxSkipatutIkkunat = 5;

        while (running) {
            double nykyinenAika = (double) System.nanoTime() / 1000000000.0;

            if ((nykyinenAika - seuraavaAika) > maxAikaero) {
                seuraavaAika = nykyinenAika;
            }

            if (nykyinenAika >= seuraavaAika) {
                seuraavaAika += aikavali;
                paivita();
                if ((nykyinenAika < seuraavaAika) || (skipatutIkkunat > maxSkipatutIkkunat)) {
                    piirra();
                    skipatutIkkunat = 1;
                } else {
                    skipatutIkkunat++;
                }
            } else {
                int sleepAika = (int) (1000.0 * (seuraavaAika - seuraavaAika));
                if (sleepAika > 0) {
                    try {
                        Thread.sleep(sleepAika);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        sammuta();
    }

    /**
     * Metodi pysäyttää run-metodin loopin suorittamisen.
     */
    public void pysayta() {
        running = false;
    }

    /**
     * Main-luokassa (Tetris-luokassa) toteutettava abstrakti metodi, joka
     * päivittää pelin tilan.
     */
    public abstract void paivita();

    /**
     * Main-luokassa (Tetris-luokassa) toteutettava abstrakti metodi, joka
     * piirtää graafiset elementit.
     */
    public abstract void piirra();

    /**
     * Main-luokassa (Tetris-luokassa) toteutettava abstrakti metodi, joka
     * käynnistää pelin.
     */
    public abstract void kaynnista();

    /**
     * Main-luokassa (Tetris-luokassa) toteutettava abstrakti metodi, joka
     * sammuttaa pelin.
     */
    public abstract void sammuta();

}
