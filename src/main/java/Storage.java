package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    
    private List <Item> allProductsList = new ArrayList<>();
    private List <Item> allProvidersList = new ArrayList<>();
    private List <Item> allConsumersList = new ArrayList<>();
    
    public List<Item> getAllProductsList() {
        return allProductsList;
    }

    public void setAllProductsList(List<Item> allProductsList) {
        this.allProductsList = allProductsList;
    }

    public List<Item> getAllProvidersList() {
        return allProvidersList;
    }

    public void setAllProvidersList(List<Item> allProvidersList) {
        this.allProvidersList = allProvidersList;
    }

    public List<Item> getAllConsumersList() {
        return allConsumersList;
    }

    public void setAllConsumersList(List<Item> allConsumersList) {
        this.allConsumersList = allConsumersList;
    }
    
    public void printList(List <Item> list) {
        if (list.isEmpty()) {
            System.out.println("list is empty");
        } else {
                System.out.println(list.get(0).getClassName() + " list:");            
                for(Item item: list) {
                    item.toString();
                }
        }
    }
    
    public void addNewProduct(List <Product> allProductsList, List <Provider> allProvidersList) {
        
        
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
                    if(product.getID() == productID) {
                        hasID = true;
                        System.out.println("Enter amount (max availible: " + product.getCount() + " QTY)");
                        while(true) {
                            int amount = scanner.nextInt();
                            if(consumer.addProduct(product, amount) == true) {
                                allConsumerList.add(consumer);            
                                consumer.printProductList(this);
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
            if(product.getID() == ID) {
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
            if(consumer.getID() == ID) {
                return consumer;
            }
        }
        return null;
    }
    
    public void deleteProduct(int ID) {
        boolean hasID = false;
        for(Product product: allProductsList) {
            if(product.getID() == ID) {
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
            if(consumer.getID() == ID) {
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