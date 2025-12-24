package org.example;

public abstract class Human {
    protected String name;
    protected int age;
    protected String gender;
    public Human(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Human(){
        this("unknown", -1, "unknown");
    }
}
