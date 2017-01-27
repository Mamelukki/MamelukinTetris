/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mamelukki.testit;

import fi.mamelukki.logiikka.Pala;
import static java.awt.Color.RED;
import static org.junit.Assert.assertEquals;
import org.junit.*;

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
        this.pala = new Pala(10, 20, RED);
    }
    
    // Pala-luokan testit kattavat vain toString-metodin, muut metodit ovat gettereitä ja settereitä
    
    @Test
    public void toStringMetodiPalauttaaOikeatArvot() {
        assertEquals(this.pala.toString(), "(10,20)");
    }
}
