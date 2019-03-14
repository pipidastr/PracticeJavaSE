package main.java;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileReadAndWrite {
    
    final static String productsFilePath = ".\\src\\main\\resources\\Products.dat";
    final static String consumersFilePath = ".\\src\\main\\resources\\Consumers.dat";
    final static String providersFilePath = ".\\src\\main\\resources\\Providers.dat";

    public static void readDataStorageByFiles(Storage storage) {
        Provider.setNextID(readDataFromFile(providersFilePath, storage.getAllProvidersList()));
        Product.setNextID(readDataFromFile(productsFilePath, storage.getAllProductsList()));
        Consumer.setNextID(readDataFromFile(consumersFilePath, storage.getAllConsumersList()));
    }
    
    public static void writeDataStorageByFiles(Storage storage) {
        writeDataFromFile(providersFilePath, storage.getAllProvidersList());
        writeDataFromFile(productsFilePath, storage.getAllProductsList());
        writeDataFromFile(consumersFilePath, storage.getAllConsumersList());
    }
    
    public static int readDataFromFile(String filePath, List <Item> list){
        int nextID = 1;
        try(FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            
            boolean hasNext = true;
           
            
            while(hasNext == true) {
                Item item = (Item)ois.readObject();
                
                if(item != null) {
                    list.add(item);
                    if(item.getID() >= nextID) {
                        nextID = item.getID() + 1;
                    }
                } else {
                    hasNext = false;
                }
                
            }
            
        } catch (EOFException ex) {
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return nextID;
    }
    
    public static void writeDataFromFile(String filePath, List <Item> list) {
        try(FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            
            for(Item item : list) {
                oos.writeObject(item);
            }
            
        }catch (IOException ex){
           ex.printStackTrace();
        }
    }

}