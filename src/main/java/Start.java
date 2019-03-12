package main.java;

import java.util.Scanner;

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
                    storage.PrintAllProductsList();
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add product/ 2 - remove product/ 3 - come back");
                        i = scanner.nextInt();
                        switch(i) {
                            case 1:
                                storage.addNewProduct(storage.allProductsList, storage.allProvidersList);
                                storage.PrintAllProductsList();
                                
                            break;
                            
                            case 2:
                                System.out.println("Enter the number of the product to be deleted");
                                i = scanner.nextInt();
                                storage.deleteProduct(i);
                                storage.PrintAllProductsList();
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                            
                        }
                    }
                break;
                
                case 2:
                    storage.PrintAllProviderList();
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add provider/ 2 - remove provider/ 3 - come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:
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
