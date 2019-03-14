package main.java;

import java.util.Scanner;

public class Start {
   public static void main(String[] args){
        Storage storage = new Storage();
        FileReadAndWrite.readDataStorageByFiles(storage);
        
        boolean exit = false;
       
        
        while (exit == false) {
        
            System.out.println("Enter: 1 - show products list/ 2 - show providers list/ 3 - show consumers list / 4 - save and exit/ 5 - exit");
            int i;
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();

            switch(i) {
                case 1:{ 
                    storage.printList(storage.getAllProductsList());
                    boolean comeBackToStart = false;
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
                                    } else {
                                        System.out.println("Error!");
                                    }
                                } else {
                                    System.out.println("Product number " + ID + " is not found.  Please enter a valid number");
                                }
                                storage.printList(storage.getAllProductsList());
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                            
                            default:{
                                System.out.println("Incorrect value");
                                break;
                            }
                        }
                    }
                break;
                }
                case 2:{
                    storage.printList(storage.getAllProvidersList());;
                    boolean comeBackToStart = false;
                    
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add provider/ 2 - remove provider/ 3 - come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:
                                String name;
                                System.out.println("Enter the name");
                                name = scanner.next();
                                
                                Provider newProvider = new Provider(name);
                                storage.addItem(newProvider, storage.getAllProvidersList());
                                storage.printList(storage.getAllProvidersList());
                            break;
                            
                            case 2:
                                System.out.println("Enter the number of the provider to be deleted");
                                i = scanner.nextInt();
                                Item delItem = storage.findItem(i, storage.getAllProvidersList());
                                
                                if(delItem != null) {
                                    if(storage.deleteItem(delItem, storage.getAllProvidersList()) ==  true) {
                                        Journal.addEntry(delItem, 2);
                                        System.out.println("Provider number " + i + " has been removed");
                                        storage.printList(storage.getAllProvidersList());
                                    } else {
                                        System.out.println("Error!");
                                    }
                                } else {
                                    System.out.println("Provider number " + i + " is not found.  Please enter a valid number");
                                }
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                            
                            default:
                                System.out.println("Incorrect value");
                            break;
                        }
                    }
                break;
                }
                case 3:{
                    storage.printProductListAllConsumers();
                    boolean comeBackToStart = false;
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add consumer and his product/ 2 - remove consumer/ 3 -  come back");
                        i = scanner.nextInt();
                        switch(i) {
                            case 1:
                                Consumer newConsumer = new Consumer();
                                int productID;
                                int countOfProduct;
                                while(true) {
                                    
                                    System.out.println("Enter product numbers separated by a space");
                                    productID = scanner.nextInt();
                                    Product product = (Product)storage.findItem(productID, storage.getAllProductsList());
                                    
                                    if(product != null ) {
                                        System.out.println("Enter amount (max availible: " + product.getCount() + " QTY)");
                                        countOfProduct = scanner.nextInt();
                                        if(countOfProduct <= product.getCount()) {
                                           storage.addProductToConsumer(product, countOfProduct, newConsumer);
                                           product.setCount(product.getCount() - countOfProduct);
                                           System.out.println("Product added!");
                                           storage.printProductListToConsumer(newConsumer);
                                           
                                           System.out.println("Enter: 1 - added more/ 2 - Apply and comeback");
                                           i = scanner.nextInt();
                                           if(i == 1) {
                                               continue;
                                           } else if (i == 2) {
                                               storage.addItem(newConsumer, storage.getAllConsumersList());
                                               Journal.addEntry(newConsumer, 1);
                                               break;
                                           } else {
                                               System.out.println("Error! Incorrect value");
                                           }
                                           
                                        } else {
                                            System.out.println("Error! Max availible: " + product.getCount() + " QTY \n Please enter the valid value");
                                        }
                                    } else {
                                        System.out.println("Product number " + productID + " is not found.  Please enter a valid number or created a new product");
                                    }
                                    
                                }
                            break;
                            
                            case 2:
                                System.out.println("Enter the number of the consumer to be deleted");
                                i = scanner.nextInt();
                                Item delItem = storage.findItem(i, storage.getAllConsumersList());
                                
                                if(delItem != null) {
                                    if(storage.deleteItem(delItem, storage.getAllConsumersList()) ==  true) {
                                        Journal.addEntry(delItem, 2);
                                        System.out.println("Consumer number " + i + " has been removed");
                                    } else {
                                        System.out.println("Error!");
                                    }
                                } else {
                                    System.out.println("Consumer number " + i + " is not found.  Please enter a valid number");
                                }
                            break;
                            
                            case 3:
                                comeBackToStart = true;
                            break;
                            
                            default:
                                System.out.println("Incorrect value");
                            break;
                        }
                    } 
                break;
                }
                case 4:
                    FileReadAndWrite.writeDataStorageByFiles(storage);
                    exit = true;
                    
                break;
                
                case 5:
                    exit = true;
                    scanner.close();
                break;
                
                default:
                    System.out.println("Incorrect value");
                break;
            } 
           
        }
        
        
    }
}
