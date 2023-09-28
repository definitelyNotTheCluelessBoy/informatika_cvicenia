package sk.uniza.fri.policko;

import javax.swing.JOptionPane;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Lovci extends Policko implements ILovci, IBojovnik {
    public Lovci(int pocetObyvatelov, int rovnobezka, int poludnik) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("orange");
    }

    @Override
    public int getMaxUtocnuSilu() {
        return super.getPocetObyvatelov();
    }

    @Override
    public int getMaxObrannuSilu() {
        return super.getPocetObyvatelov();
    }

    @Override
    public IPolicko utok(IBojovnik ciel, int silaUtoku) {
        if (ciel.getMaxObrannuSilu() > silaUtoku) {
            this.upravaStavuSil(silaUtoku);
            ciel.upravaStavuSil(silaUtoku);
            return ((IPolicko)ciel);
        } else {
            this.upravaStavuSil(silaUtoku);
            return new Policko(0, ((IPolicko)ciel).getRovnobezka(), ((IPolicko)ciel).getPoludnik());
        }

    }

    @Override
    public void upravaStavuSil(int oKolko) {
        if ((super.getPocetObyvatelov() - oKolko) <= 0) {
            super.setPocetObyvatelov(0);
        } else {
            super.setPocetObyvatelov(super.getPocetObyvatelov() - oKolko);
        }

    }

    @Override
    public IPolicko konlonizacia(IPolicko cielovePolicko, int pocetKolonizatorov) {
        if (cielovePolicko.getPocetObyvatelov() == 0) {
            Lovci novePolicko = new Lovci(pocetKolonizatorov, cielovePolicko.getRovnobezka(), cielovePolicko.getPoludnik());
            this.upravaStavuSil(pocetKolonizatorov);
            return novePolicko;
        } else {
            JOptionPane.showMessageDialog( null, "policko nieje pripravene na kolonizaciu");
            return cielovePolicko;
        }
    }

    @Override
    public IPolicko lov(IPolicko ciel, int pocetLovcov) {
        if (ciel.getPocetObyvatelov() == 0) {
            return ciel;
        } else if (ciel.getPocetObyvatelov() <= pocetLovcov) {
            return new Policko(0, ciel.getRovnobezka(), ciel.getPoludnik());
        } else {
            ciel.setPocetObyvatelov(ciel.getPocetObyvatelov() - pocetLovcov);
            return ciel;
        }
    }

    @Override
    public String dajPopis() {
        return "Policko Lovci";
    }

    @Override
    public String toString() {
        return "Lovci - Policko ma pocet obyvatelov" + super.getPocetObyvatelov();
    }

    @Override
    public void setFarba(String farba) {
        super.setFarba(farba);
    }
}
