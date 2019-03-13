package main.java;

import java.util.Scanner;

import jdk.nashorn.internal.runtime.FindProperty;

public class Start {
   public static void main(String[] args){
        Storage storage = new Storage();
        FileReadAndWrite.readDataStorageByFiles(storage);
        
        boolean exit = false;
        boolean comeBackToStart = false;
        
        while (exit == false) {
        
            System.out.println("Enter: 1 - show products list/ 2 - show providers list/ 3 - show consumers list / 4 - save and exit/ 5 - exit");
            int i;
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();

            switch(i) {
                case 1: 
                    storage.printList(storage.getAllProductsList());
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add product/ 2 - remove product/ 3 - come back");
                        i = scanner.nextInt();
                        switch(i) {
                            case 1:
                                String name;
                                double price;
                                int count;
                                int providerID;
                                boolean hasProvider = false;
                                
                                System.out.println("Enter the name");
                                name = scanner.next();
                                System.out.println("Enter the price");
                                price = scanner.nextDouble();
                                System.out.println("Enter the count");
                                count = scanner.nextInt();
                                System.out.println("Enter the number of provider");
                                providerID = scanner.nextInt();
                                
                                for(Item item : storage.getAllProvidersList()) {
                                    if(item.getID() == providerID) {
                                        hasProvider = true;
                                        Product newProduct = new Product(name, price, count, (Provider)item);
                                        storage.addItem(newProduct, storage.getAllProductsList());
                                        Journal.addEntry(newProduct, 1);
                                        storage.printList(storage.getAllProductsList());
                                    } 
                                }
                                
                                if(hasProvider == false) {
                                    System.out.println("Provider number " + providerID + " does not exist.  Please, enter a valid number or create a new provider");
                                }
                            break;
                            
                            case 2:
                                int ID;
                                System.out.println("Enter the number of the product to be deleted");
                                ID = scanner.nextInt();
                                Item delItem = storage.findItem(ID, storage.getAllProductsList());
                                
                                if(delItem != null) {
                                    if(storage.deleteItem(delItem, storage.getAllProductsList()) == true) {
                                        System.out.println("Product number " + ID + " has been removed");
                                        Journal.addEntry(delItem, 2);
                                    } 
                                } else {
                                    System.out.println("Product number " + ID + " is not found.  Please enter a valid number");
                                }
                                storage.printList(storage.getAllProductsList());
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                            
                        }
                    }
                break;
                
                case 2:
                    storage.printList(storage.getAllProvidersList());;
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add provider/ 2 - remove provider/ 3 - come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:
                                String name;
                                System.out.println("Enter the name");
                                name = scanner.nextLine();
                                
                                Provider newProvider = new Provider(name);
                                storage.addItem(newProvider, storage.getAllProvidersList());
                                storage.addNewProvider(storage.allProvidersList);
                                storage.PrintAllProviderList();
                            break;
                            
                            case 2:
                                System.out.println("Enter the number of the provider to be deleted");
                                i = scanner.nextInt();
                                storage.deleteProvider(i);
                                storage.PrintAllProviderList();
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                        }
                    }
                break;
                
                case 3:
                    storage.printAllConsumersList();
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add consumer/ 2 - remove consumer/ 3 -  come back");
                        i = scanner.nextInt();
                        switch(i) {
                            case 1:
                                storage.addNewConsumer(storage.allConsumersList);
                                
                            break;
                            
                            case 2:
                                System.out.println("Enter the number of the consumer to be deleted");
                                i = scanner.nextInt();
                                storage.deleteConsumer(i);
                                storage.printAllConsumersList();
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                        }
                    } 
                break;
                
                case 4:
                    FileReadAndWrite.writeDataStorageByFiles(storage);
                    exit = true;
                break;
                
                case 5:
                    exit = true;
                break;
                
            } 
        }
    }
}
