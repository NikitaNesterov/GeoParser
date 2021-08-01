import org.json.simple.JSONObject;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Nikita Nesterov
 */
public class CasheService {


   File file = new File("geo.cer");


    public CasheService() {}

    public CasheObject getCasheObject(CasheObject casheObject, List<CasheObject> listOfCasheObjects) {

        for(CasheObject object : listOfCasheObjects) {
            if(object.getObjectTitle().equals(casheObject.getObjectTitle())) {
                System.out.println("Объект взят из кэша");
                return object;
            }
        }
        listOfCasheObjects.add(casheObject);
        return casheObject;
    }

    public void serialize(SerialisationObject serialisationObject) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(serialisationObject);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public SerialisationObject deserialize() {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (SerialisationObject) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
