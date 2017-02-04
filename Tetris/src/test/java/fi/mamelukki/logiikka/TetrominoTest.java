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
public class TetrominoTest {

    public TetrominoTest() {
    }

    // Testit erimuotoisille Tetrominoille 
    
    @Test
    public void IPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(0);
        int[][] odotettuTulos = {{0, 0}, {0, 1}, {0, 2}, {0, -1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void KuutioPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(1);
        int[][] odotettuTulos = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void SPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(2);
        int[][] odotettuTulos = {{0, 0}, {1, 0}, {1, 1}, {0, -1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void ZPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(3);
        int[][] odotettuTulos = {{0, 0}, {1, 0}, {0, 1}, {1, -1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void TPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(4);
        int[][] odotettuTulos = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void LPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(5);
        int[][] odotettuTulos = {{0, 0}, {0, -1}, {0, 1}, {1, -1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void JPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(6);
        int[][] odotettuTulos = {{0, 0}, {0, -1}, {0, 1}, {-1, -1}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

    @Test
    public void TyhjallaPalallaOikeatArvot() {
        Tetromino pala = new Tetromino(7);
        int[][] odotettuTulos = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
        int[][] tulos = pala.getTetromino();
        assertArrayEquals(odotettuTulos, tulos);
    }

}
