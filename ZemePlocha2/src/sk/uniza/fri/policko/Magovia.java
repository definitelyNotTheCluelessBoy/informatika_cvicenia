package sk.uniza.fri.policko;

import javax.swing.JOptionPane;

public class Magovia extends Policko implements IBojovnik {
    public static final int MAGICKA_SILA = Integer.MAX_VALUE;
    private String meno;
    private boolean jeDoma = true;

    public Magovia(int pocetObyvatelov, int rovnobezka, int poludnik, String meno) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("red");
        this.meno = meno;
    }


    public String getMeno() {
        return this.meno;
    }

    @Override
    public String toString() {
        return "Magovia{" +
                "meno='" + this.meno + '\'' +
                ", jeDoma=" + this.jeDoma +
                '}';
    }

    @Override
    public String dajPopis() {
        return "mag" + this.meno + "je doma";
    }

    @Override
    public int getMaxUtocnuSilu() {
        return MAGICKA_SILA;
    }

    @Override
    public int getMaxObrannuSilu() {
        return MAGICKA_SILA;
    }

    @Override
    public IPolicko utok(IBojovnik ciel, int silaUtoku) {
        ciel.upravaStavuSil(MAGICKA_SILA);
        return new Policko(0, ((IPolicko)ciel).getRovnobezka(), ((IPolicko)ciel).getPoludnik());
    }

    @Override
    public void upravaStavuSil(int oKolko) {
    }

    @Override
    public IPolicko konlonizacia(IPolicko cielovePolicko, int pocetKolonizatorov) {
        if (cielovePolicko.getPocetObyvatelov() == 0) {
            Magovia novePolicko = new Magovia(1, cielovePolicko.getRovnobezka(), cielovePolicko.getPoludnik(), this.meno);
            super.setPocetObyvatelov(0);
            this.jeDoma = false;
            return novePolicko;
        } else {
            JOptionPane.showMessageDialog( null, "policko nieje pripravene na kolonizaciu");
            return cielovePolicko;
        }
    }
}
