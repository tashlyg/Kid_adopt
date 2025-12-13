package org.example;

import java.util.Objects;

class Kid{
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
class Shelter{
    String name;
    String location;
    int places;
    public Shelter(String name, String location, int places){
        this.name = name;
        this.location = location;
        this.places = places;
    }
    public Shelter(){
        this.name = "unknown";
        this.location = "unknown";
        this.places = -1;
    }

    void setName(String name){
        this.name = name;
    }
    void setPlaces(int places){
        this.places = places;
    }

    String getName(){
        return this.name;
    }
    String getLocation(){
        return this.location;
    }
    int getPlaces(){
        return this.places;
    }
}

public class Main {
    static void main() {
        IO.println("Hello world!");

        Adopter adopter1 = new adopter("Briar Morrow", 30, "Female");
        Adopter adopter2 = new adopter("Reyna Chang", 40, "Male");

        Kid kid1 = new kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new shelter("Det dom", "London", 14);

        IO.println("First kid name, age, gender and disease: " + kid1.getName() +", "+ kid1.getAge() +", "+ kid1.getGender() +", "+ kid1.getDisease()+'.');
        if(kid2.getAge() == kid3.getAge()){
            IO.println("for the task: compare multiple objects");
        }
        else if(Objects.equals(kid1.getGender(), adopter1.getGender())){
            IO.println("for the task: compare multiple objects");
        }
        else{
            IO.println("br br skibidi");
        }
    }
}
