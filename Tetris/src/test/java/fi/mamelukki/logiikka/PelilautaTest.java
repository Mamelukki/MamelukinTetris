/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salmisar
 */
public class PelilautaTest {

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void metodiGetPelilautaPalauttaaOikeatArvot() {
        Pelilauta pelilauta = new Pelilauta();
        int[][] odotettuTulos
                = 
                {{9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};
        int[][] tulos = pelilauta.getPelilauta();

        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void metodiTulostaPelilautaTulostaaPelilaudanOikein() {
        Pelilauta pelilauta = new Pelilauta();
        String tulos = pelilauta.tulostaPelilauta();
        String odotettuTulos
                = "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n"
                + "0000000000\n";

        assertEquals(odotettuTulos, tulos);
    }
}
