package main.java;

import java.io.Serializable;

public class Product extends Item implements Serializable{
    
    private static final long serialVersionUID = -1363689602281760557L;
    private static int nextID = 1;
    
    private String name;
    private Provider provider;
    private double price;
    private int count;
    private int ID;
    
    Product (String name, double price, int count, Provider provider){
        this.name = name;
        this.price = price;
        this.count = count;
        this.provider = provider;
        this.ID = nextID;
        nextID++;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getID() {
        return ID;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + " name: " + name + " price: " + price + " RUB  count: " + count + " QTY";
    }
    
    public static int getNextID() {
        return nextID;
    }
    
    public static void setNextID(int newNextID) {
        nextID = newNextID;
    }
    
    @Override
    public String getClassName() {
        return "Product";
    }

}