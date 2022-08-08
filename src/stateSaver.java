import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//Sathvik
public class stateSaver {

    static UltimateList readList() throws IOException, ClassNotFoundException{
        UltimateList ul;
        File file = new File("App_temp.ser");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ul = (UltimateList) ois.readObject();
        fis.close();
        ois.close();   
        return ul;     
    }

    //this method loads the current state of the arraylist into the file for future recovery
    static void writeList(UltimateList ul) throws IOException{
        File file = new File("App_temp.ser");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ul);
        fos.close();
        oos.close();        
    }
}
