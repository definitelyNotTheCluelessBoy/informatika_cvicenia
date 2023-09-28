package sk.uniza.fri.policko;

public class Draci extends Lovci {
    private int pocetHlav;

    public Draci(int pocetObyvatelov, int rovnobezka, int poludnik, int pocetHlav) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("blue");
        this.pocetHlav = pocetHlav;
    }

    public int getPocetHlav() {
        return this.pocetHlav;
    }

    @Override
    public String dajPopis() {
        return "Draci s poctom hlav" + this.pocetHlav;
    }

    @Override
    public String toString() {
        return "Draci s poctom hlav" + this.pocetHlav + "a je ich tu" + super.getPocetObyvatelov();
    }

    @Override
    public int getMaxUtocnuSilu() {
        return super.getMaxUtocnuSilu() * this.pocetHlav;
    }

    @Override
    public int getMaxObrannuSilu() {
        return super.getMaxUtocnuSilu() * this.pocetHlav;
    }

    @Override
    public IPolicko utok(IBojovnik ciel, int utocnaSila) {
        return super.utok(ciel, utocnaSila * this.pocetHlav);
    }

    @Override
    public void upravaStavuSil(int kolko) {
        int rusime = kolko / this.pocetHlav;
        super.upravaStavuSil(rusime);
    }

    @Override
    public IPolicko konlonizacia(IPolicko ns, int pocet) {
        IPolicko vysledok = super.konlonizacia(ns, pocet);
        if (vysledok instanceof Lovci) {
            vysledok = new Draci(pocet, ns.getRovnobezka(), ns.getPoludnik(), this.pocetHlav);
        }
        return vysledok;
    }

    @Override
    public IPolicko lov (IPolicko ciel, int pocetLovcov) {
        return super.lov(ciel, pocetLovcov * this.pocetHlav);
    }

}
