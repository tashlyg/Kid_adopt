package org.example;

public abstract class BaseShelters {
    protected int id;
    static int counter=1;
    public BaseShelters(){
        this.id = counter++;
    }

}
