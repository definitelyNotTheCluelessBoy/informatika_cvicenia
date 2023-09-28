package sk.uniza.fri;

import java.util.ArrayList;

/**
 * 2. 3. 2022 - 10:07
 *
 * @author Matúš
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;
    private ArrayList<Item> inventar;

    public Hrac(Miestnost miestnost) {
        this.aktualnaMiestnost = miestnost;
        this.inventar = new ArrayList<>();
        this.inventar.add(new Item("ISIC", ""));

    }

    public void vipisPredmety() {
        if (this.inventar.isEmpty()) {
            System.out.println("nic tu nieje");
        } else {
            System.out.println("Predmety");
            for (Item item : this.inventar) {
                System.out.println(item.getName());
            }
            System.out.println();
        }
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     * @param prikaz
     */
    void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Miestnost novaMiestnost = this.aktualnaMiestnost.getVychod(smer);

//        switch (smer) {
//            case "sever":
//                novaMiestnost = this.aktualnaMiestnost.getVychod("sever");
//                break;
//            case "vychod":
//                novaMiestnost = this.aktualnaMiestnost.getVychod("sever");
//                break;
//            case "juh":
//                novaMiestnost = this.aktualnaMiestnost.getVychod("juh");
//                break;
//            case "zapad":
//                novaMiestnost = this.aktualnaMiestnost.getVychod("zapad");
//                break;
//        }

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            //znova totok robime
            this.aktualnaMiestnost.vipisInfo();
        }
    }

    public void hladajPredmety() {
        this.aktualnaMiestnost.vipisPredmety();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }
}
