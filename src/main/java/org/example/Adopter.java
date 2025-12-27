package org.example;

public class Adopter extends Human{
    public Adopter(String name, int age, String gender){
        super(name, age, gender);
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
    int getID(){
        return super.id;
    }

    @Override
    public String toString() {
        return "Adopter Name:'"+ name +"', age:'"+age+"', gender:'"+gender+"'";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
