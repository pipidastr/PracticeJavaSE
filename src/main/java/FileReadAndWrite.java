package main.java;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.nio.file.*;

public class FileReadAndWrite {
    
    final static String productsFilePath = ".\\src\\main\\resources\\Products.dat";
    final static String consumersFilePath = ".\\src\\main\\resources\\Consumers.dat";
    final static String providersFilePath = ".\\src\\main\\resources\\Providers.dat";

    public static void readDataFromFiles(Storage storage) {
        readProvidersFile(providersFilePath, storage.allProvidersList);
        readProductsFile(productsFilePath, storage.allProductsList);
        readConsumersList(consumersFilePath, storage.allConsumersList);
    }
    
    public static void writeDataFromFiles(Storage storage) {
        writeProvidersFile(providersFilePath, storage.allProvidersList);
        writeProductsFile(productsFilePath, storage.allProductsList);
        writeConsumersList(consumersFilePath, storage.allConsumersList);
    }
    
    public static void readProductsFile (String fileName, List <Product> productsList) {
        try(FileInputStream fis = new FileInputStream(productsFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            boolean hasNext = true;
            while(hasNext == true) {
                Product readProduct = (Product) ois.readObject();
                if(readProduct == null) {
                    hasNext = false;
                } else {
                    productsList.add(readProduct);
                    if(readProduct.getId() == Product.getNextID()) {
                        Product.setNextID(Product.getNextID() + 1 );
                    }
                }
            }
        
        } catch(EOFException ex) {
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeProductsFile(String fileName, List <Product> productsList) {
        try(FileOutputStream fos = new FileOutputStream(productsFilePath);
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            for(Product product: productsList) {
                oos.writeObject(product);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void readProvidersFile(String fileName, List <Provider> providersList) { 
        try(FileInputStream fis = new FileInputStream(providersFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            boolean hasNext = true;
            while(hasNext == true) {
                Provider provider = (Provider) ois.readObject();
                if(provider == null) {
                    hasNext = false;
                } else {
                    providersList.add(provider);
                    if(provider.getID() == Provider.getNextID()) {
                        Provider.setNextID(Provider.getNextID() + 1 );
                    }
                }
            }
        
        } catch(EOFException ex) {
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeProvidersFile (String fileName, List <Provider> providersList) {
        try(FileOutputStream fos = new FileOutputStream(providersFilePath);
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            for(Provider provider: providersList) {
                oos.writeObject(provider);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
    public static void readConsumersList (String fileName, List <Consumer> consumersList) {
        try(FileInputStream fis = new FileInputStream(consumersFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            boolean hasNext = true;
            while(hasNext == true) {
                Consumer consumer = (Consumer) ois.readObject();
                if(consumer == null) {
                    hasNext = false;
                } else {
                    consumersList.add(consumer);
                    if(consumer.getId() == Consumer.getNextID()) {
                        Consumer.setNextID(Consumer.getNextID() + 1 );
                    }
                }
            }
        
        } catch(EOFException ex) {
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeConsumersList (String fileName, List <Consumer> consumersList) {
        try(FileOutputStream fos = new FileOutputStream(consumersFilePath);
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            for(Consumer consumer: consumersList) {
                oos.writeObject(consumer);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
   
}