package sk.uniza.fri.hlavnyBalik;


//import java.io.BufferedOutputStream;
//import java.io.DataOutputStream;
//import java.io.FileOutputStream;

import sk.uniza.fri.zamestnanci.Zamestnanec;
import sk.uniza.fri.zamestnanci.ZoznamZamestnancov;

import java.io.IOException;

//import java.util.Scanner;


/**
 *
 * @author vaclavko
 */
public class HlavnaTriedaZamestnanci {

    public static void main(String[] args) throws IOException {

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
        /*
        HlavnaTriedaZamestnanci.zapisOdmenyDoBinarnehoSuboru("odmeny.dat");
        podnik1.citajOdmenyZBinarnehoSuboru("odmeny.dat");
        */

//        System.out.println("***************** s odmenami z binarneho suboru *************");
//        System.out.println(podnik1);
//
//        System.out.println("***************** Serializacia *************");
//        try {
//            PracaSoSuborom.vlozObjektDoSuboru(podnik1, "zamestnanci.dat");
//            podnik1 = null; // zrusime povodny objekt
//            Object objekt = PracaSoSuborom.vyberObjektZoSuboru("zamestnanci.dat");
//            //bezpecne pretypovanie
//            if (objekt instanceof ZoznamZamestnancov) {
//                ZoznamZamestnancov zoznam2 = (ZoznamZamestnancov)objekt;
//                System.out.println("***************** DESerializacia *************");
//                //vypiseme  novy objekt
//                System.out.println(zoznam2);
//            }
//        } catch (ClassNotFoundException nex) {
//            //obaja su potomkovia Exception, takze na poradi nezalezi
//            System.out.println("Doslo k chybe - nenajdena trieda***" + nex.getMessage());
//        } catch (IOException ioex) {
//            System.out.println("Doslo k chybe - vstupy vystupy***" + ioex.getMessage());
//
//        } catch (Exception ex) {
//            //zachytenie vsetkych dalsich vynimiek, napriklad pretypovanie by nevyslo
//            System.out.println("Doslo k inej chybe***" + ex.getMessage());
//        }

        podnik1.addZamestnanca("zamestnanec1.dat");
        podnik1.addZamestnanca("zamestnanec2.dat");
        podnik1.addZamestnanca1("zamestnanec3.txt");
        System.out.println("Pridani zamestnanci");
        System.out.println(podnik1);

    }



}
