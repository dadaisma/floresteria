package florist.persistence;
import florist.models.Product;

import java.io.*;

public class PersistenceJson {
    private static PersistenceJson instance;
    private String file = "florist.txt";

    private PersistenceJson() {}

    public static PersistenceJson getInstance() {
        if (instance == null) {
            instance = new PersistenceJson();
        }
        return instance;
    }

    public void saveFlorist(Florist florist) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(florist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Florist loadFlorist() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Florist) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}