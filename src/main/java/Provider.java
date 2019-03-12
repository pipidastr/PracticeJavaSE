package main.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Provider extends Item implements Serializable{

    private static final long serialVersionUID = -2994953547927924480L;
    private static int nextID = 1;
    
    private String name;
    private int ID;
    private List<Integer> productsIDList = new ArrayList<>();
    
    Provider(String name){
        this.name = name;
        this.ID = nextID;
        nextID++;
    }
    
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int getID() {
        return ID;
    }
    
    public List <Integer> getProductsIDList(Storage storage) {
        return productsIDList;
    }

    public void setProductsIDList(List<Integer> productsList) {
        this.productsIDList = productsList;
    }
    
    public static int getNextID() {
        return nextID;
    }
    
    public static void setNextID(int newNextID) {
        nextID = newNextID;
    }
    
    @Override
    public String toString() {
        return ID + " " + name;
    }
    @Override
    public String getClassName() {
        return "Provider";
    }

}