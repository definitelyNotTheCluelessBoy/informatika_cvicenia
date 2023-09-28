package sk.uniza.fri.sklad;

import sk.uniza.fri.tovar.Tovar;

/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
public class PolozkaSkladu {
    private Tovar tovar;
    private int pocetKusov;

    public PolozkaSkladu(Tovar tovar, int pocetKusov) {
        this.tovar = tovar;
        this.pocetKusov = pocetKusov;
    }

    public Tovar getTovar() {
        return this.tovar;
    }

    public int getPocetKusov() {
        return this.pocetKusov;
    }

    public boolean odoberKusy(int pocet) {
        if (pocet > 0 && pocet <= this.pocetKusov) {
            this.pocetKusov -= pocet;
            return true;
        }
        return false;
    }

    public boolean pridajKusy(int pocet) {
        if (pocet > 0) {
            this.pocetKusov += pocet;
            return true;
        }
        return false;
    }

    public void vypis() {
        this.tovar.vypis();
        System.out.format("v pocte: %10d %2s", this.pocetKusov, "ks");
        System.out.println();
    }
}

