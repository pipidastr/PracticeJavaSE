package main.java;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Consumer implements Serializable, Item{
    private static int nextID = 1;
    private int ID;
    private double totalPrice;
    private Map <Integer, Integer> productsList = new HashMap<>();
    
    public Consumer () {
        this.ID = nextID;
        nextID++;
    }
    
    public int getId() {
        return ID;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public Map <Integer, Integer> getProductsIDList() {
        return productsList;
    }
    
    public static int getNextID() {
        return nextID;
    }
    
    public static void setNextID(int newNextID) {
        nextID = newNextID;
    }
    
    public boolean addProduct(Product product, int count) {
        if(product.getCount() < count) {
            System.out.println("Maximum availible: " + product.getCount() + " QTY)");
            return false;
        } else {
            productsList.put(product.getId(), count);
            product.setCount(product.getCount() - count);
            totalPrice+=product.getPrice()*count;
            return true;
        }
    }   
    
    public void printProductList (Storage storage) {
        for (Integer key: productsList.keySet()) {
            for (Product i: storage.allProductsList){
                if(i.getId() == (int)key) {
                    System.out.println(ID + " " + i.getId() +  " " + i.getName() + " " + i.getPrice() + " " + "RUB " + productsList.get(key) + " QTY" + " finaly " + i.getPrice()*productsList.get(key) + " RUB");
                }
            }
        }
    }
    
    @Override
    public String getNameClass() {
        return "Consumer";
    }

    
}