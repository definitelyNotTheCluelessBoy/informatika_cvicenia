package sk.uniza.fri.policko;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
public interface IBojovnik {
    int getMaxUtocnuSilu();
    int getMaxObrannuSilu();
    IPolicko utok(IBojovnik ciel, int silaUtoku);
    void upravaStavuSil(int oKolko);
    IPolicko konlonizacia(IPolicko novySvet, int pocetKolonizatorov);
}
