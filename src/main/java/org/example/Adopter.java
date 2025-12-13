package org.example;

class Adopter{
    String name;
    int age;
    String gender;
    public Adopter(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Adopter(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
    }

    void setName(String name){
        this.name = name;
    }
    void setGender(String gender){
        this.gender = gender;
    }

    String getName(){
        return this.name;
    }
    int getAge(){
        return this.age;
    }
    String getGender(){
        return this.gender;
    }
}
