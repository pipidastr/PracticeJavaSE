package main.java;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Consumer extends Item implements Serializable{

    private static final long serialVersionUID = -1326514726591363183L;
    private static int nextID = 1;
    
    private int ID;
    private double totalPrice;
    private Map <Integer, Integer> productsList = new HashMap<>();
    
    public Consumer () {
        this.ID = nextID;
        nextID++;
    }
    @Override
    public int getID() {
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
            productsList.put(product.getID(), count);
            product.setCount(product.getCount() - count);
            totalPrice+=product.getPrice()*count;
            return true;
        }
    }   
    
    @Override
    public String getClassName() {
        return "Consumer";
    }

    
}