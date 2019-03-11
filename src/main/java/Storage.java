package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    
    

    List <Product> allProductsList = new ArrayList<>();
    List <Provider> allProvidersList = new ArrayList<>();
    List <Consumer> allConsumersList = new ArrayList<>();
    
    
    public void PrintAllProductsList() {
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
    
    public void PrintAllProviderList() {
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

    
    public void printAllConsumersList() {
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
    
    public void addNewProduct(List <Product> allProductsList, List <Provider> allProvidersList) {
        
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
    
    public void addNewProvider(List <Provider> allProvidersList) {
        Scanner scanner = new Scanner(System.in);
        String name;
        
        System.out.println("Enter the name");
        name = scanner.next();
        Provider provider = new Provider(name);
        allProvidersList.add(provider);
        Journal.addEntry(provider, 1);
        
    }
    
    public void addNewConsumer(List <Consumer> allConsumerList) {
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
    
    public Product findProduct(int ID) {
        for(Product product: allProductsList) {
            if(product.getId() == ID) {
                return product;
            } 
        }
        return null;
    }
    
    public Provider findProvider(int ID) {
        for(Provider provider: allProvidersList) {
            if(provider.getID() == ID) {
                return provider;
            } 
        }
        return null;
    }
    
    public Consumer findConsumer(int ID) {
        for(Consumer consumer: allConsumersList) {
            if(consumer.getId() == ID) {
                return consumer;
            }
        }
        return null;
    }
    
    public void deleteProduct(int ID) {
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
    
    public void deleteProvider(int ID) {
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
    
    public void deleteConsumer(int ID) {
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