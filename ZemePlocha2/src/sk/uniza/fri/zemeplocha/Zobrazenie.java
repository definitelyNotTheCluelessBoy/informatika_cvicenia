package sk.uniza.fri.zemeplocha;

import sk.uniza.fri.hlavnyBalik.FieldNotFoundException;
import sk.uniza.fri.policko.IPolicko;

import java.io.FileNotFoundException;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Zobrazenie {
    private final int pocetPolicok;
    private Obdlznik[][] zobrazenie;

    public Zobrazenie(int pocetPolicok) {
        this.pocetPolicok = pocetPolicok;
        this.zobrazenie = new Obdlznik[pocetPolicok][pocetPolicok];

        for (int i = 0; i < pocetPolicok; i++) {
            for (int j = 0; j < pocetPolicok; j++) {
                this.zobrazenie[j][i] = new Obdlznik(j * 50, i * 50);
            }
        }
    }

    private void nastavZobrazenie(Zemeplocha zem) {
        for (int i = 0; i < this.pocetPolicok; i++) {
            for (int j = 0; j < this.pocetPolicok; j++) {
                try {
                    IPolicko policko = zem.getPolicko(j, i);
                    this.zobrazenie[j][i].zmenFarbu(policko.getFarba());
                } catch (FieldNotFoundException e) {
                    System.out.println("policko sa nenaslo");
                }
            }
        }
    }

    public void zobraz(Zemeplocha zem) {
        this.nastavZobrazenie(zem);
        for (Obdlznik[] riadok : this.zobrazenie) {
            for (Obdlznik obdlznik : riadok) {
                obdlznik.zobraz();
            }
        }
    }

    public void skry() {
        for (Obdlznik[] riadok : this.zobrazenie) {
            for (Obdlznik obdlznik : riadok) {
                obdlznik.skry();
            }
        }
    }
}
