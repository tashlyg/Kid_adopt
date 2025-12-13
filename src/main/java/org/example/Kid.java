package org.example;

public class Kid{
    String name;
    int age;
    String gender;
    String disease;
    public Kid(String name, int age, String gender, String disease){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }
    public Kid(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.disease = "unknown";
    }

    void setName(String name){
        this.name = name;
    }
    void setDisease(String disease){
        this.disease = disease;
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
    String getDisease(){
        return this.disease;
    }
}
