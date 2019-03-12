package main.java;

public abstract class Item {

    abstract public String getClassName();
    abstract public int getID();

    public double getPrice() {
       return 0.0d;
    }
    
    public String getName() {
        return "Not name";
    }
    
    public static int getNextID() {
        return 0;
    }
    
    public static void setNextID(int ID) {}
}

