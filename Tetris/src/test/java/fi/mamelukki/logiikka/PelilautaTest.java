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
 * Pelilauta-luokan testit keskeisille metodeille, kuten palojen siirtämiselle
 *
 * @author salmisar
 */
public class PelilautaTest {

    private Pelilauta pelilauta;

    public PelilautaTest() {
        this.pelilauta = new Pelilauta();
    }

    @Test
    public void metodiGetPelilautaPalauttaaOikeatArvot() {
        int[][] odotettuTulos
                = {{9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
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
        int[][] tulos = this.pelilauta.getPelilauta();

        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void testDrawTetromino() {
        Pelilauta.pala = new Tetromino(0);
        this.pelilauta.merkitseTetromino();
        int[][] odotettuTulos = {
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
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
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };
        System.out.println(this.pelilauta.tulostaPelilauta());
        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }

    @Test
    public void metodiSiirraOikealleSiirtaaPalanOikealle() {
        Pelilauta.pala = new Tetromino(0);
        this.pelilauta.merkitseTetromino();

        int[][] odotettuTulos = {
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9},
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
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        for (int i = 0; i < 8; i++) {
            Pelilauta.pala = this.pelilauta.siirraOikealle();
        }

        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }

    @Test
    public void metodiSiirraVasemmalleSiirtaaPalanVasemmalle() {
        Pelilauta.pala = new Tetromino(0);
        this.pelilauta.merkitseTetromino();
        int[][] odotettuTulos = {
            {9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 9},
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
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        Pelilauta.pala = this.pelilauta.siirraVasemmalle();
        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }

    @Test
    public void metodiSiirraAlasSiirtaaPalanAlemmas() {
        Pelilauta.pala = new Tetromino(0);
        pelilauta.merkitseTetromino();
        int[][] odotettuTulos = {
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9},
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
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        Pelilauta.pala = this.pelilauta.siirraAlas();
        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }

    @Test
    public void metodiPoistaTetrominoPoistaaTetrominonPelilaudalta() {
        this.pelilauta.merkitseTetromino();
        this.pelilauta.poistaTetromino();
        int[][] odotettuTulos = {
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
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }

    @Test
    public void metodiTulostaPelilautaTulostaaPelilaudanOikein() {
        String tulos = this.pelilauta.tulostaPelilauta();
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

    @Test
    public void josPalalleOnTilaaOnkoTilaaMetodiPalauttaaTrue() {
        Tetromino pala = new Tetromino();
        boolean tulos = this.pelilauta.onkoTilaa(pala.getTetromino(), this.pelilauta.getXArvo(), this.pelilauta.getYArvo() + 1);
        assertEquals(tulos, true);
    }

    @Test
    public void josPalalleEiOleTilaaOnkoTilaaMetodiPalauttaaFalse() {
        Pelilauta.pala = new Tetromino(1);
        this.pelilauta.setYArvo(3);
        this.pelilauta.merkitseTetromino();
        this.pelilauta.setYArvo(1);
        this.pelilauta.merkitseTetromino();
        boolean tulos = this.pelilauta.onkoTilaa(this.pelilauta.pala.getTetromino(), this.pelilauta.getXArvo(), this.pelilauta.getYArvo() + 1);
        assertEquals(tulos, false);
    }

    @Test
    public void josPalaMeneeReunojenYliOnkoTilaaMetodiPalauttaaFalse() {
        Tetromino pala = new Tetromino(0);
        this.pelilauta.setXArvo(1);
        this.pelilauta.merkitseTetromino();
        boolean tulos = this.pelilauta.onkoTilaa(pala.getTetromino(), this.pelilauta.getXArvo() - 1, this.pelilauta.getYArvo());
        assertEquals(tulos, false);
    }

    @Test
    public void metodiKaannaKaantaaTetrominon() {
        Pelilauta.pala = new Tetromino(0);
        int[][] odotettuTulos = {
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 9},
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
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        Pelilauta.pala.kaanna();
        this.pelilauta.merkitseTetromino();
        assertArrayEquals(odotettuTulos, this.pelilauta.getPelilauta());
    }
}
