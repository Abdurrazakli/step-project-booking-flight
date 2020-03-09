package dao;

import java.io.*;
import java.util.*;

public class Database<E> {

    public Optional<List<E>> read(String filePath){ //Read file
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return Optional.of((List<E>) ois.readObject());//TODO: UNCHECKED CAST? HANDLE: LEAVE IT LIKE THIS
        }catch (IOException | ClassNotFoundException e){
            return Optional.empty();
        }
    }

    public Boolean write(String filePath, List<E> objectList) {
        try{
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectList);
            return true;
        }catch (IOException e){
            return false;
        }
    }

    public void init(){

    }
}
