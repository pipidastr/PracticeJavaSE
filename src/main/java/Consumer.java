package main.java;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Consumer implements Serializable, Working{
    
    private int ID;
    private double totalPrice;
    private static int nextID = 1;
    private Map <Integer, Integer> productsList = new HashMap<>(); //key = Product ID, value = the amount of product purchased by the buyer 
    
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
        }
        else {
            productsList.put(product.getId(), count);
            product.setCount(product.getCount() - count);
            totalPrice+=product.getPrice()*count;
            return true;
        }
    }   
    
    public void printProductList () {
        for (Integer key: productsList.keySet()) {
            for (Product i: Storage.allProductsList){
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