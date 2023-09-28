package sk.uniza.fri;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je s inymi miestnostami spojena vychodmi.
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private HashMap<String, Miestnost> vychody;
    private String popisMiestnosti;
    private ArrayList<Item> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {

        this.popisMiestnosti = popis;
        this.vychody = new HashMap<String, Miestnost>();
        this.predmety = new ArrayList<>();
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     *
     */
    public void nastavVychod(String nazov, Miestnost vychod) {
        this.vychody.put(nazov, vychod);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {

        return this.popisMiestnosti;
    }

    public Miestnost getVychod(String str) {
        return this.vychody.get(str);
    }

    public void vipisInfo() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        //  !!!!!priamy pristup k public atributom !!!
        for (String nazov: this.vychody.keySet()) {
            System.out.print(nazov + " ");
        }
    }

    public boolean pridajItem(Item item) {
        return this.predmety.add(item);
    }

    public void vipisPredmety() {
        if (this.predmety.isEmpty()) {
            System.out.println("nic tu nieje");
        } else {
            System.out.println("Predmety");
            for (Item item : this.predmety) {
                System.out.println(item.getName());
            }
            System.out.println();
        }
    }
}
