package sk.uniza.fri.zemeplocha;

import sk.uniza.fri.hlavnyBalik.FieldNotFoundException;
import sk.uniza.fri.policko.Draci;
import sk.uniza.fri.policko.IPolicko;
import sk.uniza.fri.policko.Lovci;
import sk.uniza.fri.policko.Magovia;
import sk.uniza.fri.policko.Policko;
import sk.uniza.fri.policko.Zajace;

import java.util.Random;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Zemeplocha {
    private final int pocetPolicok;
    private IPolicko[][] policka;

    public Zemeplocha(int pocetPolicok) {
        this.pocetPolicok = pocetPolicok;
        this.policka = new IPolicko[pocetPolicok][pocetPolicok];

        for (int i = 0; i < this.pocetPolicok; i++) {
            for (int j = 0; j < this.pocetPolicok; j++) {
                this.policka[j][i] = new Policko(0, j, i);
            }
        }

    }

    public void nastavPolicka() {
        Random random = new Random();

        for (int i = 0; i < this.pocetPolicok; i++) {
            for (int j = 0; j < this.pocetPolicok; j++) {
                int nahoda = random.nextInt(100);
                if (nahoda <= 60) {
                    Zajace zajac = new Zajace(random.nextInt(100), this.policka[j][i].getRovnobezka(), this.policka[j][i].getPoludnik());
                    this.policka[j][i] = zajac;
                } else if (nahoda <= 95) {
                    Lovci lovec = new Lovci(random.nextInt(40), this.policka[j][i].getRovnobezka(), this.policka[j][i].getPoludnik());
                    this.policka[j][i] = lovec;
                } else {
                    Draci drak = new Draci(random.nextInt(10), this.policka[j][i].getRovnobezka(), this.policka[j][i].getPoludnik(), random.nextInt(10));
                    this.policka[j][i] = drak;
                }
            }


        }

        int randomX = random.nextInt(this.pocetPolicok);
        int randomY = random.nextInt(this.pocetPolicok);
        Magovia mag = new Magovia(1, this.policka[randomX][randomY].getRovnobezka(), this.policka[randomY][randomX].getPoludnik(), "cheater");
        this.policka[randomX][randomY] = mag;

    }

    public int getPocetPolicok() {
        return this.pocetPolicok;
    }

    public IPolicko getPolicko(int rovnobezka, int poludnik) throws FieldNotFoundException {
        if (rovnobezka < this.pocetPolicok && poludnik < this.pocetPolicok && rovnobezka >= 0 && poludnik >= 0) {
            return this.policka[rovnobezka][poludnik];
        } else {
            throw new FieldNotFoundException(rovnobezka, poludnik, this.pocetPolicok);
        }
    }

    public boolean setPolicko(IPolicko vkladanePolicko, int rovnobezka, int poludnik) {
        if (rovnobezka < this.pocetPolicok && poludnik < this.pocetPolicok) {
            this.policka[rovnobezka][poludnik] = vkladanePolicko;
            return true;
        } else {
            return false;
        }
    }

    public void kuzloMnozenia() {
        for (IPolicko[] riadok : this.policka) {
            for (IPolicko policko : riadok) {
                policko.setPocetObyvatelov(policko.getPocetObyvatelov() / 2 + policko.getPocetObyvatelov());
            }
        }
    }
}
