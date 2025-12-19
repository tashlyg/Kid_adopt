package org.example;

public class Employer {
    String name;
    int age;
    String gender;
    int salary;
    String shelter;
    public Employer(String name, int age, String gender, int salary, String shelter){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.shelter = shelter;
    }
    public Employer(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.salary = -1;
        this.shelter = "unknown";
    }
    void setName(String name){
        this.name = name;
    }
    void setSalary(int salary){
        this.salary = salary;
    }
    void setShelter(String shelter){
        this.shelter = shelter;
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
    int setSalary(){
        return this.salary;
    }
    String setShelter(){
        return this.shelter;
    }
}
