package sk.uniza.fri;

/**
 * 2. 3. 2022 - 10:07
 *
 * @author Matúš
 */
public class Item {
    private String name;
    private String popis;

    public Item(String name, String popis) {
        this.name = name;
        this.popis = popis;
    }

    public String getName() {
        return this.name;
    }

    public String getPopis() {
        return this.popis;
    }
}
