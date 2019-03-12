package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Journal {

    public static void addEntry(Item item, int IDofOperation) {
        
        try(FileWriter writer = new FileWriter(".\\src\\main\\resources\\Journal.txt", true)){
            switch (IDofOperation) {
                case 1:{
                    writer.write(new Date().toString() + " " + item.getClassName() + " added: " + item.toString() + "\r\n");
                    writer.flush();
                    writer.close();
                    break;
                }
                case 2:{
                    writer.write(new Date().toString() + " " + item.getClassName() + " deleted: " + item.toString() + "\r\n");
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
