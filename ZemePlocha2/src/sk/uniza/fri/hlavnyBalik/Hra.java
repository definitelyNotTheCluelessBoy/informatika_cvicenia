package sk.uniza.fri.hlavnyBalik;

import sk.uniza.fri.policko.IBojovnik;
import sk.uniza.fri.policko.ILovci;
import sk.uniza.fri.policko.IPolicko;
import sk.uniza.fri.policko.Policko;
import sk.uniza.fri.zemeplocha.Zemeplocha;
import sk.uniza.fri.zemeplocha.Zobrazenie;

import javax.swing.JOptionPane;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public class Hra {

    private Zemeplocha zem;
    private Zobrazenie obraz;

    public Hra(int rozmer) {
        this.zem = new Zemeplocha(rozmer);
        this.obraz = new Zobrazenie(rozmer);
        this.zem.nastavPolicka();
        this.obraz.zobraz(this.zem);

    }

    public boolean existujePolicko(int rovnobezka, int poludnik) {
        try {
            this.zem.getPolicko(rovnobezka, poludnik);
            return true;
        } catch (FieldNotFoundException e) {
            return false;
        }
    }


    public void vypisPolicko(int rovnobezka, int poludnik) {
        try {
            JOptionPane.showMessageDialog(null, this.zem.getPolicko(rovnobezka, poludnik).toString() + " suradnica X: " + rovnobezka + ", suradnica Y: " + poludnik);
        } catch (FieldNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public IPolicko vyberPolicko(String nadpis) {

        String helpStringOne = JOptionPane.showInputDialog(null, "daj poludnik", nadpis);
        while (helpStringOne == null) {
            helpStringOne = JOptionPane.showInputDialog(null, "daj poludnik", nadpis);
        }
        int poludnik = Integer.parseInt(helpStringOne);

        String helpStringTwo = JOptionPane.showInputDialog(null, "daj rovnobezku", nadpis);
        while (helpStringTwo == null) {
            helpStringTwo = JOptionPane.showInputDialog(null, "daj rovnobezku", nadpis);
        }
        int rovnobezka = Integer.parseInt(helpStringTwo);

        try {
            this.vypisPolicko(rovnobezka, poludnik);
            return this.zem.getPolicko(rovnobezka, poludnik);
        } catch (FieldNotFoundException e) {
            return this.vyberPolicko(nadpis);
        }
    }

    public void lov() {
        IPolicko lovec = this.vyberPolicko("vyber lovca");
        IPolicko korist = this.vyberPolicko("vyber korist");

        while (!(lovec instanceof ILovci) || !(lovec instanceof IBojovnik)) {
            JOptionPane.showMessageDialog(null, "lovcom je korist vyber lovca znova");
            lovec = this.vyberPolicko("vyber lovca");
        }

        while (korist instanceof ILovci || korist instanceof IBojovnik) {
            JOptionPane.showMessageDialog(null, "koristou je lovec vyber korist znova");
            korist = this.vyberPolicko("vyber korist");
        }

        int pocetLovcov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet lovcov"));

        while (pocetLovcov > lovec.getPocetObyvatelov()) {
            JOptionPane.showMessageDialog(null, "tolko lovcoc nieje zvol si pocet znova \n hint: maximalny pocet obyvatelov na policku lovcov je" + lovec.getPocetObyvatelov());
            pocetLovcov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet lovcov"));
        }

        IPolicko novePolicko = ((ILovci)lovec).lov(korist, pocetLovcov);
        this.zem.setPolicko(novePolicko, novePolicko.getRovnobezka(), novePolicko.getPoludnik());

    }

    public void boj() {
        IPolicko utocnik = this.vyberPolicko("vyber utocnika");
        IPolicko obranca = this.vyberPolicko("vyber obrancu");

        while (!(utocnik instanceof IBojovnik)) {
            JOptionPane.showMessageDialog(null, "utocnikom nieje bojovnik vyber znova");
            utocnik = this.vyberPolicko("vyber utocnika");
        }

        while (!(obranca instanceof IBojovnik)) {
            JOptionPane.showMessageDialog(null, "obrancom nieje bojovnik vyber znova");
            obranca = this.vyberPolicko("vyber obrancu");
        }

        int pocetUtocnikov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet utocnikov"));

        while (pocetUtocnikov > utocnik.getPocetObyvatelov()) {
            JOptionPane.showMessageDialog(null, "tolko utocnikov nieje zvol si pocet znova \n hint: maximalny pocet obyvatelov na policku utocnika je" + utocnik.getPocetObyvatelov());
            pocetUtocnikov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet utocnikov"));
        }

        IPolicko novePolicko = ((IBojovnik)utocnik).utok(((IBojovnik)obranca), pocetUtocnikov);
        this.zem.setPolicko(novePolicko, novePolicko.getRovnobezka(), novePolicko.getPoludnik());

        if (utocnik.getPocetObyvatelov() == 0) {
            IPolicko novePrazdnePolicko = new Policko(0, utocnik.getRovnobezka(), utocnik.getPoludnik());
            this.zem.setPolicko(novePrazdnePolicko, utocnik.getRovnobezka(), utocnik.getPoludnik());
        }

    }

    private void kolonizacia() {
        IPolicko kolonizator = this.vyberPolicko("vyber kolonizatora");
        IPolicko kolonizovane = this.vyberPolicko("vyber kolonizovane");

        while (!(kolonizator instanceof ILovci) || !(kolonizator instanceof IBojovnik)) {
            JOptionPane.showMessageDialog(null, "kolonizatorom je korist vyber kolonizatora znova");
            kolonizator = this.vyberPolicko("vyber kolonizatora");
        }

        int pocetKolonizatorov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet kolonizatorov"));

        while (pocetKolonizatorov > kolonizator.getPocetObyvatelov()) {
            JOptionPane.showMessageDialog(null, "tolko Kolonizatorov nieje zvol si pocet znova \n hint: maximalny pocet obyvatelov na policku Kolonizatorov je" + kolonizator.getPocetObyvatelov());
            pocetKolonizatorov = Integer.parseInt(JOptionPane.showInputDialog(null, "zadaj pocet Kolonizatorov"));
        }

        IPolicko novePolicko = ((IBojovnik)kolonizator).konlonizacia(kolonizovane, pocetKolonizatorov);
        this.zem.setPolicko(novePolicko, novePolicko.getRovnobezka(), novePolicko.getPoludnik());

        if (kolonizator.getPocetObyvatelov() == 0) {
            IPolicko novePrazdnePolicko = new Policko(0, kolonizator.getRovnobezka(), kolonizator.getPoludnik());
            this.zem.setPolicko(novePrazdnePolicko, kolonizator.getRovnobezka(), kolonizator.getPoludnik());
        }
    }

    private void kuzloMnozenia() {
        this.zem.kuzloMnozenia();
    }

    /*
    inspiracia metodou hraj z hodiny (ja by som vsetko robil cez if else, if else, if else...)
     */

    public void hraj() {
        boolean koniec = false;

        while (!koniec) {
            String testString = JOptionPane.showInputDialog(null, "info o policku - 1 \n lov - 2 \n kolonizacia - 3 \n mnoz - 4 \n boj - 5 \n koniec - 0");
            while (testString == null) {
                testString = JOptionPane.showInputDialog(null, "info o policku - 1 \n lov - 2 \n kolonizacia - 3 \n mnoz - 4 \n boj - 5 \n koniec - 0");
            }

            int volba = Integer.parseInt(testString);

            switch (volba) {
                case 1 -> this.vyberPolicko("");
                case 2 -> {
                    this.lov();
                    this.obraz.skry();
                    this.obraz.zobraz(this.zem);
                }
                case 3 -> {
                    this.kolonizacia();
                    this.obraz.skry();
                    this.obraz.zobraz(this.zem);
                }

                case 4 -> {
                    this.kuzloMnozenia();
                    this.obraz.skry();
                    this.obraz.zobraz(this.zem);
                }
                case 5 -> {
                    this.boj();
                    this.obraz.skry();
                    this.obraz.zobraz(this.zem);
                }
                case 0 -> {
                    koniec = true;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "znova");
                }

            }
        }
        System.exit(0);
    }
}