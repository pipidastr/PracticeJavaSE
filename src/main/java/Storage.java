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
    
    public boolean addItem(Item item, List <Item> list) {
        list.add(item);
        Journal.addEntry(item, 1);
        return true;
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
    
    public boolean deleteItem (Item item, List <Item> list) {
        return list.remove(item);
    }
    
    public Item findItem(int ID, List <Item> list) {
        for(Item item : list) {
            if(item.getID() == ID) {
                return item;
            }
        }
        
        return null;
    }
}
