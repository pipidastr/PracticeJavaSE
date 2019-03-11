package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Journal {

    public static void addEntry(Object object, int IDofOperation) {
        
        try(FileWriter writer = new FileWriter("Journal.txt", true)){
            switch (IDofOperation) {
                case 1:{
                    if(object instanceof Product){
                        writer.write(new Date().toString() + " " + "Product added: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    if(object instanceof Provider) {
                        writer.write(new Date().toString() + " " + "Provider added: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    if(object instanceof Consumer) {
                        writer.write(new Date().toString() + " " + "Consumer added: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    break;
                }
                
                case 2:{
                    if(object instanceof Product){
                        writer.write(new Date().toString() + " " + "Product deleted: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    if(object instanceof Provider) {
                        writer.write(new Date().toString() + " " + "Provider deleted: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    if(object instanceof Consumer) {
                        writer.write(new Date().toString() + " " + "Consumer deleted: " + object.toString() + "\r\n");
                        writer.flush();
                        writer.close();
                    }
                    break;
                }
            }
        } 
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
