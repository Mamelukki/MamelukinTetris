/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.testit.logiikka;

import fi.mamelukki.logiikka.Pala;
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
public class PalaTest {

    private Pala pala;

    public PalaTest() {

    }

    @Before
    public void setUp() {
        this.pala = new Pala(10, 20, null);
    }

    @Test
    public void palaLiikkuuOikeanVerran() {
        pala.liiku(10, 10);
        assertEquals(pala.getX(), 20);
        assertEquals(pala.getY(), 30);
    }

    @Test
    public void toStringMetodiTulostaaKoordinaatitOikein() {
        assertEquals(pala.toString(), "(10,20)");
    }
    
}
    
