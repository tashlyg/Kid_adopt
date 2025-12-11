package org.example;

class kid{
    String name;
    int age;
    String gender;
    String disease;
    public kid(String name, int age, String gender, String disease){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }
}

class adopter{
    String name;
    int age;
    String gender;
    public adopter(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
class shelter{
    String name;
    String location;
    int places;
    public shelter(String name, String location, int places){
        this.name = name;
        this.location = location;
        this.places = places;
    }
}

public class Main {
    static void main() {
        IO.println("Hello world!");

        adopter adopter1 = new adopter("Briar Morrow", 30, "Famale");
        adopter adopter2 = new adopter("Reyna Chang", 40, "Male");

        kid kid1 = new kid("Fatima Copeland", 7, "Female", "healthy");
        kid kid2 = new kid("Keegan Lu", 10, "Male", "No left arm");
        kid kid3 = new kid("Benson Curtis", 14, "Male", "Brainroot");

        shelter shelter1 = new shelter("Det dom", "London", 14);

        int i = 1;
        IO.println("i = " + i);
    }
}
