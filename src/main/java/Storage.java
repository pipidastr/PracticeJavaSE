package main.java;

import java.util.ArrayList;
import java.util.List;

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
                    System.out.println(item.toString());
                }
        }
    }
    
    public boolean addItem(Item item, List <Item> list) {
        Journal.addEntry(item, 1);
        return list.add(item);
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
    
    public void addProductToConsumer(Product product, int count, Consumer consumer) {
        consumer.getProductList().put(product.getID(), count);
    }
    
    public void printProductListToConsumer(Consumer consumer) {
        Product product;
        for(Integer key : consumer.getProductList().keySet()) {
            product = (Product) findItem(key, allProductsList);
            if( product != null) {
                System.out.println("ID: " + product.getID() + " Name: " 
                        + product.getName() + " price: " + product.getPrice() 
                        + " RUB Amount: " + consumer.getProductList().get(key)
                        + " OTY \nFinally: " + product.getPrice() 
                                    * consumer.getProductList().get(key) + "RUB \n");
            } else continue;
        }
        
        System.out.println("\n\n\n");
    }
    
    public void printProductListAllConsumers() {
        for(Item consumer : allConsumersList) {
            System.out.println(consumer.toString());
            printProductListToConsumer((Consumer)consumer);
            
        }
    }
}
