package sample;
import java.io.*;

public class Serializer {
    public static Object deserialize(File fileName) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        BufferedInputStream buff = new BufferedInputStream(fin);
        ObjectInputStream fout = new ObjectInputStream(buff);
        Object obj = fout.readObject();
        fout.close();
        return obj;
    }

    public static void serialize(Object obj, File fileName) throws IOException {
        FileOutputStream fout = new FileOutputStream(fileName);
        BufferedOutputStream buff = new BufferedOutputStream(fout);
        ObjectOutputStream oos = new ObjectOutputStream(buff);
        oos.writeObject(obj);
        oos.close();
    }
}