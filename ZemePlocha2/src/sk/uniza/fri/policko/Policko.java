package sk.uniza.fri.policko;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Policko implements IPolicko {
    private int pocetObyvatelov;
    private int rovnobezka;
    private int poludnik;
    private String farba;

    public Policko(int pocetObyvatelov, int rovnobezka, int poludnik) {
        this.pocetObyvatelov = pocetObyvatelov;
        this.rovnobezka = rovnobezka;
        this.poludnik = poludnik;
        this.farba = "black";
    }

    @Override
    public int getPocetObyvatelov() {
        return this.pocetObyvatelov;
    }

    @Override
    public void setPocetObyvatelov(int pocetObyvatelov) {
        this.pocetObyvatelov = pocetObyvatelov;
    }

    @Override
    public String getFarba() {
        return this.farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    @Override
    public String dajPopis() {
        return "Policko";
    }

    @Override
    public int getRovnobezka() {
        return this.rovnobezka;
    }

    @Override
    public int getPoludnik() {
        return this.poludnik;
    }

    @Override
    public String toString() {
        return "Policko ma pocet obyvatelov: " + this.pocetObyvatelov;
    }

    public void setRovnobezka(int rovnobezka) {
        this.rovnobezka = rovnobezka;
    }

    public void setPoludnik(int poludnik) {
        this.poludnik = poludnik;
    }
}
