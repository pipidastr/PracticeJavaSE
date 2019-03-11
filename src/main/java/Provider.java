package main.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Provider implements Serializable, Working {
    
    private String name;
    private int ID;
    private static int nextID = 1;
    private List<Integer> productsIDList = new ArrayList<>();
    
    Provider(String name){
        this.name = name;
        this.ID = nextID;
        nextID++;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    
    public List <Integer> getProductsIDList() {
        for(Product product: Storage.allProductsList) {
            if(product.getProvider().getID() == ID) {
                productsIDList.add(product.getId()); 
            }
        }
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
    
    public void printProductList() {
        for(Product product: Storage.allProductsList) {
            if(product.getProvider().getID() == ID) {
                System.out.println(product.toString());
            }
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return ID + " " + name;
    }
    @Override
    public String getNameClass() {
        return "Provider";
    }

}