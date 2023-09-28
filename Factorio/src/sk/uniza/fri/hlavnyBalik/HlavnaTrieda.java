package sk.uniza.fri.hlavnyBalik;

import sk.uniza.fri.podnik.MajetokPodniku;
import sk.uniza.fri.podnik.IOcenitelny;
import sk.uniza.fri.podnik.Pozemok;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaclavko
 * @version 01/2015
 */
public class HlavnaTrieda {

    public static void main(String[] args) {

        MajetokPodniku podnik1 = new MajetokPodniku("Moja firma");
        Tovar t1 = new Tovar(101, "ponozky", 2.0);
        Tovar t2 = new Tovar(102, "pancuchy", 4.0);

        //podnik1.pridajMajetok(t2);

        Sklad sklad1 = new Sklad(25);
        podnik1.addMajetok(sklad1);

        PolozkaSkladu polSk1 = new PolozkaSkladu(t1, 10);
        //podnik1.pridajMajetok(polSk1);

        Sklad sklad2 = new Sklad(42);
        podnik1.addMajetok(sklad2);

        Pozemok pozemok1 = new Pozemok("Pod hajom", 100, 200, 0.05);
        podnik1.addMajetok(pozemok1);

        System.out.println("Zoznam majetku");
        System.out.println("****************");
        System.out.println(podnik1.dajZoznamMajetku());

        System.out.println("********************");

        PolozkaSkladu polSk2 = new PolozkaSkladu(t1, 5);
        PolozkaSkladu polSk3 = new PolozkaSkladu(t2, 5);
        podnik1.pridajTovarNaSklad(25, polSk2);
        podnik1.pridajTovarNaSklad(42, polSk3);
        podnik1.pridajTovarNaSklad(42, polSk1);

        podnik1.vypisPodniku();

        System.out.println("***************");
        System.out.println("Celkove naklady:" + podnik1.dajCelkoveNaklady());

        System.out.println("****Testovacky***********");
        IOcenitelny ocen = new Sklad(99);
        //skusit odblokovat
        //ocen.pridajTovarNaSklad(polSk1);
        System.out.println(ocen.dajPopis());
        ocen = new Pozemok("Moj pozemok", 10, 20, 0.001);
        //skusit odblokovat
        //ocen.getSirku();
        System.out.println(ocen.dajPopis());
        ((Pozemok)ocen).getSirku();

    }

}
