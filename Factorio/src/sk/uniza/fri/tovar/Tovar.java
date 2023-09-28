package sk.uniza.fri.tovar;

/**
 * 21. 2. 2022 - 18:05
 *
 * @author Matúš
 */
public class Tovar {
    private int id;
    private String nazov;
    private double nakupnaCenaZaKus;

    public Tovar(int id, String nazov, double nakupnaCenaZaKus) {
        this.id = id;
        this.nazov = nazov;
        this.nakupnaCenaZaKus = nakupnaCenaZaKus;
    }

    public int getIdTovaru() {
        return this.id;
    }

    public String getNazov() {
        return this.nazov;
    }

    public double getNakupnaCenaZaKus() {
        return this.nakupnaCenaZaKus;
    }

    public void vypis() {
        System.out.print(this.id + ". ");
        System.out.format("%-20s", this.nazov);
        System.out.print(", v jednotkovej cene: ");
        System.out.format("%-10.0001f", this.nakupnaCenaZaKus);

    }

    public String dajPopis() {
        return " id tovaru: " + this.id + ", nazov tovaru: " + this.nazov;
    }

}
