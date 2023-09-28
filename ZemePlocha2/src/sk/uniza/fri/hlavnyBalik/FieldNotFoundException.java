package sk.uniza.fri.hlavnyBalik;

//import static java.lang.Math.abs;

public class FieldNotFoundException extends Exception {
    private final String errorMesage;
    private final int x;
    private final int y;
    private final int mierka;

    public FieldNotFoundException(int x, int y, int mierka) {
        this.errorMesage = "Herné políčko pre súradnice X = " + x + ", Y = " + x + " sa nenašlo";
        this.mierka = mierka;
        this.x = x;
        this.y = y;
    }


    private int preratajNajblizsiuSuradnicuX() {
        if (this.x >= this.mierka) {
            return this.x - this.mierka + 1;
        } else {
            return 0;
        }

    }

    private int preratajNajblizsiuSuradnicuY() {
        if (this.y >= this.mierka) {
            return this.y - this.mierka + 1;
        } else {
            return 0;
        }
    }

    @Override
    public String getMessage() {
        return this.errorMesage + "\n Najblišie políčko sa nachádza o " + this.preratajNajblizsiuSuradnicuX() + " bodov na X osi na západ a o " + this.preratajNajblizsiuSuradnicuY() + " bodov na Y suradnici na sever";
    }
}
