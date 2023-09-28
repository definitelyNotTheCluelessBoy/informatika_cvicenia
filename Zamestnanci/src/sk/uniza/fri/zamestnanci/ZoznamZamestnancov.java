package sk.uniza.fri.zamestnanci;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vaclavko
 * trieda urcena studentom
 */
public class ZoznamZamestnancov implements Serializable {
    private final ArrayList<Zamestnanec> pracovnici;



    public ZoznamZamestnancov() {
        this.pracovnici = new ArrayList<Zamestnanec> ();

    }

    public void zapisDoTextovehoSuboru(String path) {
        try {
            File subor = new File(path);
            PrintWriter w = new PrintWriter(subor);
            w.println("V nasom podniku pracuju nasledovni zamestnanci:");
            for (Zamestnanec zamestnanec : this.pracovnici) {
                w.println(zamestnanec.toString());
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean addZamestnanca(Zamestnanec zamestnanec) {

        return this.pracovnici.add(zamestnanec);
    }

    public String toString()   {
        String ret = String.format("V nasom podniku pracuju nasledovni zamestnanci: %n")  ;
        for (Zamestnanec pomZam : this.pracovnici) {
            ret = ret + pomZam + "\n";
        }
        return ret;
    }

    public Zamestnanec poskytniZamestnanca(int osobneCislo) {
        Zamestnanec hladany = null;
        boolean nasiel = false;
        int i = 0;

        while ((!nasiel) && (this.pracovnici.size() > i )) {
            Zamestnanec pomZam = this.pracovnici.get(i);
            if (pomZam.getOsobneCislo() == osobneCislo) {
                hladany = pomZam;
                nasiel = true;
            }
            i++;
        }
        if (!nasiel) {
            throw new IllegalArgumentException("nenasiel sa tipec");
        }
        return hladany;
    }

    public void citajOdmenyZTextovehoSuboru(String path) {
        try {
            File subor = new File(path);
            Scanner scanner = new Scanner(subor);
            while (scanner.hasNextLine()) {

                int osobenCislo = scanner.nextInt();
                System.out.println(osobenCislo);
                int suma = scanner.nextInt();
                try {
                    Zamestnanec zamestnanec = this.poskytniZamestnanca(osobenCislo);
                    zamestnanec.setOdmeny(suma);
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean nastavOdmenyZamestnancovi(int osobneCislo, int odmeny) {
        try {
            Zamestnanec zam = this.poskytniZamestnanca(osobneCislo);
            zam.setOdmeny(odmeny);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Zamestnanec najdiNajmenejZarabajuceho() {
        Zamestnanec min = null;
        double minPlat = Double.MAX_VALUE;
        for (Zamestnanec pomZam : this.pracovnici) {
            if (pomZam.getCelkovyPlat() < minPlat) {
                min = pomZam;
                minPlat = pomZam.getCelkovyPlat();
            }
        }
        return min;
    }

    public void citajOdmenyZBinarnehoSuboru(String nazov) {

        try {
            int overovaci = 1;
            FileInputStream stream = new FileInputStream(nazov);
            DataInputStream data = new DataInputStream(stream);
            while (overovaci == 1) {
                try {
                    int id = data.readInt();
                    int suma = data.readInt();
                    System.out.println("****" + id + suma);
                    this.nastavOdmenyZamestnancovi(id, suma);

                } catch (EOFException e) {
                    overovaci = 0;

                }


            }
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean addZamestnanca(String path) {
        try {
            int overovaci = 1;
            FileInputStream stream = new FileInputStream(path);
            DataInputStream data = new DataInputStream(stream);

            try {
                int id = data.readInt();
                String meno = data.readUTF();
                int suma = data.readInt();
                Zamestnanec zamestnanec = new Zamestnanec(id, meno, suma);
                this.addZamestnanca(zamestnanec);
                return true;

            } catch (EOFException e) {
                overovaci = 0;

            }

            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addZamestnanca1(String path) {
        try {
            File stream = new File(path);
            Scanner data = new Scanner(stream);
            int osc = data.nextInt();
            String meno = "";
            while (!data.hasNextInt()) {
                meno += data.next() + " ";
            }
            int plat = data.nextInt();
            Zamestnanec zamestnanec = new Zamestnanec(osc, meno, plat);
            this.addZamestnanca(zamestnanec);

            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
