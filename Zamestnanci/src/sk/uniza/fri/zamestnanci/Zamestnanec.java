package sk.uniza.fri.zamestnanci;


import java.io.Serializable;

public class Zamestnanec implements Serializable {

    private final int osobneCislo;
    private final String meno;
    private double zakladnaVyskaPlatu = 0;
    private int odmeny = 0;



    public Zamestnanec(int osCislo, String meno, double plat) {
        this.meno = meno;
        this.osobneCislo = osCislo;
        this.zakladnaVyskaPlatu = plat;
    }


    public int getOsobneCislo() {

        return this.osobneCislo;
    }

    public double getVyskuZakladnehoPlatu() {

        return this.zakladnaVyskaPlatu;
    }

    public void setOdmeny(int paOdmeny) {

        this.odmeny = paOdmeny;
    }

    public double getCelkovyPlat() {

        return this.zakladnaVyskaPlatu + this.odmeny;
    }

    public String toString() {
        String pomOdmeny = " ";
        if (this.odmeny > 0) {
            pomOdmeny += "a ma mesacne odmeny " + this.odmeny;
        }
        return String.format("Osc: %d. %s, s platom:%10.2f %s", this.osobneCislo, this.meno, this.zakladnaVyskaPlatu, pomOdmeny);
    }

}

