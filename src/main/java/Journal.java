package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Journal {

    public static void addEntry(Item object, int IDofOperation) {
        
        try(FileWriter writer = new FileWriter(".\\src\\main\\resources\\Journal.txt", true)){
            switch (IDofOperation) {
                case 1:{
                    writer.write(new Date().toString() + " " + object.getNameClass() + " added: " + object.toString() + "\r\n");
                    writer.flush();
                    writer.close();
                    break;
                }
                case 2:{
                    writer.write(new Date().toString() + " " + object.getNameClass() + " deleted: " + object.toString() + "\r\n");
                    writer.flush();
                    writer.close();
                    break;
                }
            }
        } 
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
