package sk.uniza.fri.policko;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Zajace extends Policko {
    public Zajace(int pocetObyvatelov, int rovnobezka, int poludnik) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("green");
    }

    @Override
    public String dajPopis() {
        return "Policko zajace";
    }

    @Override
    public String toString() {
        return "Zajace - Policko ma pocet obyvatelov " + super.getPocetObyvatelov();
    }



}
