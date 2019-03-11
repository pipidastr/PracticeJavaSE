package main.java;

import java.io.Serializable;

public class Product implements Serializable, Item{
    static private int nextID = 1;
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

    public int getId() {
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
    
    static int getNextID() {
        return nextID;
    }
    
    static void setNextID(int newNextID) {
        nextID = newNextID;
    }
    
    @Override
    public String getNameClass() {
        return "Product";
    }

}