package sk.uniza.fri.policko;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public interface IPolicko {
    int getPocetObyvatelov();
    void setPocetObyvatelov(int pocetObyvatelov);
    String getFarba();
    String toString();
    String dajPopis();
    int getRovnobezka();
    int getPoludnik();
}
