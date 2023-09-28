package sk.uniza.fri.hlavnyBalik;

//import zamestnanci.ZoznamZamestnancovMoj;


import sk.uniza.fri.zamestnanci.Zamestnanec;
import sk.uniza.fri.zamestnanci.ZoznamZamestnancov;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author vaclavko
 */
public class HlavnyProgram {
    public static void main(String[] args) {

        Zamestnanec zamestna1 = new Zamestnanec(100, "Karol Smely", 1500);
        Zamestnanec zamestna2 = new Zamestnanec(101, "Janka Cistotna", 600);
        Zamestnanec zamestna3 = new Zamestnanec(102, "Alica Krasna", 800);
        Zamestnanec zamestna4 = new Zamestnanec(103, "Jozef Megakoder", 1200);
        Zamestnanec zamestna5 = new Zamestnanec(104, "Petra Krasna", 450);
        Zamestnanec zamestna6 = new Zamestnanec(105, "Zuzana Testerova", 500);
        Zamestnanec zamestna7 = new Zamestnanec(106, "Andrej Koder", 1000);
        Zamestnanec zamestna8 = new Zamestnanec(107, "Ivetka Kontrolna", 800);
        Zamestnanec zamestna9 = new Zamestnanec(108, "Milan Systemovy", 900);


        ZoznamZamestnancov podnik1 = new ZoznamZamestnancov();

        podnik1.addZamestnanca(zamestna1);
        podnik1.addZamestnanca(zamestna2);
        podnik1.addZamestnanca(zamestna3);
        podnik1.addZamestnanca(zamestna4);
        podnik1.addZamestnanca(zamestna5);
        podnik1.addZamestnanca(zamestna6);
        podnik1.addZamestnanca(zamestna7);
        podnik1.addZamestnanca(zamestna8);
        podnik1.addZamestnanca(zamestna9);


        System.out.println(podnik1);

        podnik1.zapisDoTextovehoSuboru("zamestnanci.txt");


        //podnik1.citajOdmenyZTextovehoSuboru("odmeny.txt");
        podnik1.citajOdmenyZBinarnehoSuboru("odmeny.dat");

        System.out.println("***************** s odmenami z textoveho *************");
        System.out.println(podnik1);

        //HlavnyProgram.zapisOdmenyDoBinarnehoSuboru("odmeny.dat", podnik1);

/*
***

        HlavnaTrieda.zapisOdmenyDoBinarnehoSuboru("odmeny.dat");

        podnik1.citajOdmenyZBinarnehoSuboru("odmeny.dat");


        System.out.println("***************** s odmenami z binarneho suboru *************");
        System.out.println(podnik1);
*/

    }

    public static void zapisOdmenyDoBinarnehoSuboru(String nazov, ZoznamZamestnancov zoznamZamestnancov) {
        int overovaci = 1;


        try {
            Scanner scanner = new Scanner(System.in);

            FileOutputStream stream = new FileOutputStream(nazov);
            DataOutputStream data = new DataOutputStream(stream);
            while (overovaci == 1) {
                System.out.println("daj id");
                int id = scanner.nextInt();
                System.out.println("daj sumu");
                int suma = scanner.nextInt();
                System.out.println("chces pokracovat?");
                overovaci = scanner.nextInt();
                data.writeInt(id);
                data.writeInt(suma);

            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
