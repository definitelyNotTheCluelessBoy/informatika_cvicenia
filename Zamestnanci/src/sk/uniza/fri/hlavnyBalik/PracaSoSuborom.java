package sk.uniza.fri.hlavnyBalik;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 11. 4. 2022 - 17:03
 *
 * @author Matúš
 */
public class PracaSoSuborom {
    public static void vlozObjektDoSuboru(Object paObjekt, String paNazovSuboru) throws IOException {
        FileOutputStream file = new FileOutputStream(paNazovSuboru);
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.writeObject(paObjekt);
        stream.close();
        file.close();
    }


    public static Object vyberObjektZoSuboru(String s) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(s);
        ObjectInputStream stream = new ObjectInputStream(file);
        Object object;
        object = stream.readObject();
        stream.close();
        return object;
    }
}
