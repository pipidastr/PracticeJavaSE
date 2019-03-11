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
    


    final static String productsFile = "Products.dat";
    final static String consumersFile = "Consumers.dat";
    final static String providersFile = "Providers.dat";

    public static void readDataFromFiles(Storage storage) {
        readProvidersFile(providersFile, storage.allProvidersList);
        readProductsFile(productsFile, storage.allProductsList);
        readConsumersList(consumersFile, storage.allConsumersList);
    }
    
    public static void writeDataFromFiles(Storage storage) {
        writeProvidersFile(providersFile, storage.allProvidersList);
        writeProductsFile(productsFile, storage.allProductsList);
        writeConsumersList(consumersFile, storage.allConsumersList);
    }
    
    public static void readProductsFile (String fileName, List <Product> productsList) {
        
        try(FileInputStream fis = new FileInputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Products.dat");
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
        
        try(FileOutputStream fos = new FileOutputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Products.dat");
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            
            for(Product product: productsList) {
                oos.writeObject(product);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void readProvidersFile(String fileName, List <Provider> providersList) {
        
        try(FileInputStream fis = new FileInputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Providers.dat");
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
        try(FileOutputStream fos = new FileOutputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Providers.dat");
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){

            for(Provider provider: providersList) {
                oos.writeObject(provider);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
    public static void readConsumersList (String fileName, List <Consumer> consumersList) {
        try(FileInputStream fis = new FileInputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Consumers.dat");
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
        
        try(FileOutputStream fos = new FileOutputStream("D:\\practice\\PracticeJavaSE\\src\\main\\resources\\Consumers.dat");
            ObjectOutputStream oos =  new ObjectOutputStream(fos)){
            
            for(Consumer consumer: consumersList) {
                oos.writeObject(consumer);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
 
}