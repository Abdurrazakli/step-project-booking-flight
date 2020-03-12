package dao;

import entity.Flight;
import util.FlightGenerator;

import java.io.*;
import java.util.*;

public class FileOperations<E> {

    public List<E> read(String filePath){ //Read file
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<E> objects = (List<E>) ois.readObject();
            ois.close();
            fis.close();
            return objects;
        }catch (IOException | ClassNotFoundException e){
            return Collections.emptyList();
        }
    }

    public Boolean write(String filePath, List<E> objectList) {
        try{
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectList);
            oos.close();
            fos.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }


    public void __init__(){
        FileOperations<Flight> db = new FileOperations<>();
        db.write(FlightGenerator.FLIGHT_DB_PATH,FlightGenerator.generate());
    }
}
