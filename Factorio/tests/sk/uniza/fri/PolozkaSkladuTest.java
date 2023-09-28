package sk.uniza.fri;

import org.junit.Assert;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.tovar.Tovar;

/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
public class PolozkaSkladuTest {
    PolozkaSkladu ps;
    Tovar t;
    @org.junit.Before
    public void setUp() throws Exception {
        t = new Tovar(100, "klavesnica", 20);
        ps = new PolozkaSkladu(t, 5);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("koniec");
    }

    @org.junit.Test
    public void getPocetKusov() {
        Assert.assertEquals(20,ps.getPocetKusov());
    }

    @org.junit.Test
    public void pridajKusy() {
        Assert.assertTrue(ps.pridajKusy(10));
    }

    @org.junit.Test
    public void overTrue() {
        Assert.assertEquals(true, false);
    }
}