package org.example;

public abstract class Human {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;
     static int counter=1;
    public Human(String name, int age, String gender){
        this.id = this.counter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Human(){
        this("unknown", -1, "unknown");
    }
}
