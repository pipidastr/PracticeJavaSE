package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    
    

    static List <Product> allProductsList = new ArrayList<>();
    static List <Provider> allProvidersList = new ArrayList<>();
    static List <Consumer> allConsumersList = new ArrayList<>();
    
    
    public static void main(String[] args){
        
        FileReadAndWrite.readDataFromFiles();
        
        boolean exit = false;
        
        while (exit == false) {
        
            System.out.println("Enter: 1 - show products list/ 2 - show providers list/ 3 - show consumers list / 4 - save and exit/ 5 - exit");
            int i;
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();

            switch(i) {
                case 1: {
                    PrintAllProductsList();
                    boolean comeBackToStart = false;
                    
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add product/ 2 - remove product/ 3 - come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:{
                                addNewProduct(allProductsList, allProvidersList);
                                PrintAllProductsList();
                                
                            } break;
                            
                            case 2:{
                                System.out.println("Enter the number of the product to be deleted");
                                i = scanner.nextInt();
                                deleteProduct(i);
                                PrintAllProductsList();
                            } break;
                            
                            case 3:{
                                comeBackToStart = true;
                                break;
                            }
                        }
                    }
                } break;
                
                
                case 2:{
                    PrintAllProviderList();
                    boolean comeBackToStart = false;
                    
                    while(comeBackToStart == false) {
                        System.out.println("Enter: 1 - add provider/ 2 - remove provider/ 3 - come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:{
                                addNewProvider(allProvidersList);
                                PrintAllProviderList();
                            } break;
                            case 2:{
                                System.out.println("Enter the number of the provider to be deleted");
                                i = scanner.nextInt();
                                deleteProvider(i);
                                PrintAllProviderList();
                            } break;
                            case 3:{
                                comeBackToStart = true;
                            } break;
                        }
                    }
                } break;
                
                case 3:{
                    
                    printAllConsumersList();
                    boolean comeBackToStart = false;
                    
                    while(comeBackToStart == false) {
        
                        System.out.println("Enter: 1 - add consumer/ 2 - remove consumer/ 3 -  come back");
                        i = scanner.nextInt();
                        
                        switch(i) {
                            case 1:{
                                addNewConsumer(allConsumersList);
                                
                            } break;
                            
                            case 2:{
                                System.out.println("Enter the number of the consumer to be deleted");
                                i = scanner.nextInt();
                                deleteConsumer(i);
                                printAllConsumersList();
                            } break;
                            case 3:{
                                comeBackToStart = true;
                            } break;
                        }
                    } 
                } break;
                
                case 4:{
                    FileReadAndWrite.writeDataFromFiles();
                    exit = true;
                } break;
                
                case 5:{
                    exit = true;
                }
            } 
        }
        
        

    }
    
    
    
    
    
    public static void PrintAllProductsList() {
        if (allProductsList.isEmpty()) {
            System.out.println("Product list is empty");
        }
        else {
                System.out.println("Product list:");
                for(Product product: allProductsList) {
                    System.out.println(product.toString());
                }
            }
    }
    
    public static void PrintAllProviderList() {
        if (allProvidersList.isEmpty()) {
            System.out.println("Provider list is empty");
        }
        else {
                System.out.println("Provider list:");            
                for(Provider provider: allProvidersList) {
                    System.out.println(provider.toString());
                }
            }
    }

    
    public static void printAllConsumersList() {
        if (allConsumersList.isEmpty()) {
            System.out.println("Consumers list is empty");
        }
        else {
                System.out.println("Consumers list:");            
                for(Consumer consumer: allConsumersList) {
                    consumer.printProductList();
                }
        }
            
    }
    
    public static void addNewProduct(List <Product> allProductsList, List <Provider> allProvidersList) {
        
        Scanner scanner = new Scanner(System.in);
        String name;
        double price;
        int count;
        int providerID;
        
        System.out.println("Enter the name");
        name = scanner.next();
        System.out.println("Enter the price");
        price = scanner.nextDouble();
        System.out.println("Enter the count");
        count = scanner.nextInt();
        System.out.println("Enter the number of provider");
        providerID = scanner.nextInt();
        
        boolean hasProviderNumber = false;
        
        for(Provider provider: allProvidersList) {
            if(provider.getID() == providerID) {
                Product product = new Product(name, price, count, provider);
                allProductsList.add(product);
                Journal.addEntry(product, 1);
                hasProviderNumber = true;
            }
        }
        
        if(hasProviderNumber = false) {
            System.out.println("Provider number " + providerID + " does not exist.  Please, enter a valid number or create a new provider");
        }
    }
    
    public static void addNewProvider(List <Provider> allProvidersList) {
        Scanner scanner = new Scanner(System.in);
        String name;
        
        System.out.println("Enter the name");
        name = scanner.next();
        Provider provider = new Provider(name);
        allProvidersList.add(provider);
        Journal.addEntry(provider, 1);
        
    }
    
    public static void addNewConsumer(List <Consumer> allConsumerList) {
        Scanner scanner = new Scanner(System.in);
        Consumer consumer = new Consumer();
        
        while(true) {
            System.out.println("Enter product numbers separated by a space");
            boolean hasID = false;
            while (hasID != true) {
                int productID = scanner.nextInt();
                for(Product product: allProductsList) {
                    if(product.getId() == productID) {
                        hasID = true;
                        System.out.println("Enter amount (max availible: " + product.getCount() + " QTY)");
                        while(true) {
                            int amount = scanner.nextInt();
                            if(consumer.addProduct(product, amount) == true) {
                                allConsumerList.add(consumer);            
                                consumer.printProductList();
                                break;
                            } else continue;
                        }
                    }
                } 
                if(hasID == false) {
                    System.out.println("Product number " + productID + " does not exist.  Please, enter a valid number or create a new product");
                    continue;
                }
            }
            
            System.out.println("Enter: 1 - add more/ 2 - accept and return");
            int i = scanner.nextInt();
            
            if(i == 1) {
                continue;
            } else {
                Journal.addEntry(consumer, 1);
                break;
            }
        }
    }
    
    public static Product findProduct(int ID) {
        for(Product product: allProductsList) {
            if(product.getId() == ID) {
                return product;
            } 
        }
        return null;
    }
    
    public static Provider findProvider(int ID) {
        for(Provider provider: allProvidersList) {
            if(provider.getID() == ID) {
                return provider;
            } 
        }
        return null;
    }
    
    public static Consumer findConsumer(int ID) {
        for(Consumer consumer: allConsumersList) {
            if(consumer.getId() == ID) {
                return consumer;
            }
        }
        return null;
    }
    
    public static void deleteProduct(int ID) {
        boolean hasID = false;
        for(Product product: allProductsList) {
            if(product.getId() == ID) {
                allProductsList.remove(product);
                Journal.addEntry(product, 2);
                hasID = true;
                System.out.println("Product number " + ID + " has been removed");
                break;
            }
        }
        if (hasID = false) {
            System.out.println("Product number " + ID + " is not found.  Please enter a valid number");
        }
        
    }
    
    public static void deleteProvider(int ID) {
        boolean hasID = false;
        for(Provider provider: allProvidersList) {
            if(provider.getID() == ID) {
                allProvidersList.remove(provider);
                Journal.addEntry(provider, 2);
                hasID = true;
                System.out.println("Provider number " + ID + " has been removed");
                break;
            }
        }
        if (hasID = false) {
            System.out.println("Provider number " + ID + " is not found.  Please enter a valid number");
        }
    }
    
    public static void deleteConsumer(int ID) {
        boolean hasID = false;
        for(Consumer consumer: allConsumersList) {
            if(consumer.getId() == ID) {
                allConsumersList.remove(consumer);
                Journal.addEntry(consumer, 2);
                hasID = true;
                System.out.println("Consumer number " + ID + " has been removed");
                break;
            }
        }
        if (hasID = false) {
            System.out.println("Consumer number " + ID + " is not found.  Please enter a valid number");
        }
    }

}