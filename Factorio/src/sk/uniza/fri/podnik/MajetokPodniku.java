package sk.uniza.fri.podnik;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;

import java.util.ArrayList;
/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
public class MajetokPodniku {
    private String nazovPodniku;
    private ArrayList<IOcenitelny> zoznam;

    public MajetokPodniku(String nazovPodniku) {
        this.nazovPodniku = nazovPodniku;
        this.zoznam = new ArrayList<>();
    }

//    public boolean vlastniUzSklad(Sklad jeden) {
//        for (Sklad sklad: this.zoznam) {
//            if (sklad.getCisloSkladu() == Sklad)
//
//        }
//    }

    public boolean addMajetok(IOcenitelny jeden) {
        return this.zoznam.add(jeden);
    }

    public IOcenitelny odoberMajetok(int index) {
        return this.zoznam.remove(index);
    }

    public IOcenitelny poskytniMajetok(int index) {
        return this.zoznam.get(index);
    }

    public String dajZoznamMajetku() {
        String finalString = "";
        int counter = 0;
        for (IOcenitelny polozka: this.zoznam) {
            finalString += (counter + ". Sklad cislo: " + polozka.dajPopis() + "\n");
            counter++;
        }
        return finalString;
    }

    public int dajPocetKusovMajetku() {
        int finalCount = 0;
        for (IOcenitelny polozka: this.zoznam) {
            finalCount += 1;
        }
        return finalCount;
    }

    public Sklad poskytniSklad(int cisloSkladu) {
        Sklad najdeny = null;
        for (IOcenitelny polozka: this.zoznam) {
            if (polozka instanceof Sklad) {
                Sklad skladDva = (Sklad)polozka;
                if (skladDva.getCisloSkladu() == cisloSkladu) {
                    return skladDva;
                }
            }
        }
        return null;
    }

    public boolean pridajTovarNaSklad(int cisloSkladu, PolozkaSkladu polozka) {
        if (this.poskytniSklad(cisloSkladu) != null) {
            return this.poskytniSklad(cisloSkladu).pridajTovarNaSklad(polozka);
        }
        return false;
    }

    public PolozkaSkladu zrusTovarZoSkladu(int cisloSkladu, int idTovaru) {
        if (this.poskytniSklad(cisloSkladu) != null) {
            return this.poskytniSklad(cisloSkladu).zrusTovarZoSkladu(idTovaru);
        }
        return null;
    }

    public boolean odoberKusyTovaruNaSklade(int cisloSkladu, int idTovaru, int pocetKusov) {
        if (this.poskytniSklad(cisloSkladu) != null) {
            return this.poskytniSklad(cisloSkladu).odoberKusyTovaruNaSklade(idTovaru, pocetKusov);
        }
        return false;
    }

    public void vypisSklad(int cisloSkladu) {
        if (this.poskytniSklad(cisloSkladu) != null) {
            this.poskytniSklad(cisloSkladu).vypisSklad();
        }
    }

    public void vypisPodniku() {
        for (IOcenitelny polozka: this.zoznam) {
            polozka.vypis();
        }
    }

    public double dajCelkoveNaklady() {
        double naklady = 0;
        for (IOcenitelny polozka: this.zoznam) {
            naklady += polozka.dajNaklady();

        }
        return naklady;
    }
}
