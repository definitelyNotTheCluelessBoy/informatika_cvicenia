package sk.uniza.fri.sklad;

import sk.uniza.fri.podnik.IOcenitelny;

import java.util.ArrayList;

/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
public class Sklad implements IOcenitelny {
    private int cisloSkladu;
    private ArrayList<PolozkaSkladu> tovarNaSklade;

    public Sklad(int cisloSkladu) {
        this.cisloSkladu = cisloSkladu;
        this.tovarNaSklade = new ArrayList<PolozkaSkladu>();
    }

    private int dajIndexTovaru(int id) {
        for (PolozkaSkladu polozka : this.tovarNaSklade) {
            if (polozka.getTovar().getIdTovaru() == id) {
                return this.tovarNaSklade.indexOf(polozka);
            }
        }
        return 404;
    }

    public int getCisloSkladu() {
        return this.cisloSkladu;
    }

    public boolean pridajTovarNaSklad(PolozkaSkladu polozka) {
        if (this.dajIndexTovaru(polozka.getTovar().getIdTovaru()) != 404) {
            return this.tovarNaSklade.get(this.dajIndexTovaru(polozka.getTovar().getIdTovaru())).pridajKusy(polozka.getPocetKusov());
        } else {
            return this.tovarNaSklade.add(polozka);
        }
    }

    public boolean odoberKusyTovaruNaSklade(int id, int pocetKusov) {
        if (this.dajIndexTovaru(id) != 404) {
            return this.tovarNaSklade.get(this.dajIndexTovaru(id)).odoberKusy(pocetKusov);
        }
        return false;
    }

    public PolozkaSkladu zrusTovarZoSkladu(int id) {
        if (this.dajIndexTovaru(id) != 404) {
            if (this.tovarNaSklade.get(this.dajIndexTovaru(id)).getPocetKusov() == 0) {
                return this.tovarNaSklade.remove(this.dajIndexTovaru(id));
            }
        }
        return null;
    }

    public void vypisSklad() {
        System.out.println("-----------------------------------------");
        System.out.println("Zoznam tovaru na sklade cislo: " + this.cisloSkladu);
        System.out.println("-----------------------------------------");
        for (PolozkaSkladu polozka : this.tovarNaSklade) {
            polozka.vypis();
        }
    }

    @Override
    public double dajNaklady() {
        double cena = 0;
        for (PolozkaSkladu polozka: this.tovarNaSklade) {
            cena += polozka.getPocetKusov() * polozka.getTovar().getNakupnaCenaZaKus();

        }
        return cena;
    }

    public String dajPopis() {
        StringBuilder finalString = new StringBuilder();
        for (PolozkaSkladu polozkaSkladu: this.tovarNaSklade) {
            finalString.append(polozkaSkladu.getTovar().dajPopis()).append(" ");
        }
        return "sklad cislo: " + this.cisloSkladu + ", polozky na sklade: " + finalString;
    }

    @Override
    public void vypis() {
        this.vypisSklad();

    }

    public int dajPocetPoloziek() {
        return this.tovarNaSklade.size();
    }

    public PolozkaSkladu poskytniPolozku(int index) {
        return this.tovarNaSklade.get(index);
    }
}
