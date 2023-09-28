package sk.uniza.fri;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.uniza.fri.podnik.MajetokPodniku;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;

/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
class MajetokPodnikuTest {
    Sklad sklad;
    MajetokPodniku podnik;
    PolozkaSkladu polozkaSkladu;
    Tovar tovar;

    @BeforeEach
    void setUp() {
        this.tovar = new Tovar(100, "klavesnica", 20);
        this.polozkaSkladu = new PolozkaSkladu(this.tovar, 5);
        this.podnik = new MajetokPodniku("moj podnik");
        this.sklad = new Sklad(34);
        this.sklad.pridajTovarNaSklad(this.polozkaSkladu);
        this.podnik.addMajetok(this.sklad);
    }

    @AfterEach
    void tearDown() {
        System.out.println("koniec");
    }

    @Test
    void poskytniSklad() {
        Assert.assertEquals(this.sklad, this.podnik.poskytniSklad(34));
    }

    @Test
    void pridajTovarNaSklad() {
        Assert.assertTrue(this.sklad.pridajTovarNaSklad(this.polozkaSkladu));
    }

    @Test
    void zrusTovarZoSkladu() {
        Assert.assertEquals(this.polozkaSkladu, this.sklad.zrusTovarZoSkladu(100));
    }

    @Test
    void odoberKusyTovaruNaSklade() {
        Assert.assertTrue(this.sklad.odoberKusyTovaruNaSklade(100,5));
    }
}