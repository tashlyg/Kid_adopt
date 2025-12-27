package org.example;

public class Employer extends Human{
    int salary;
    String shelter;
    public Employer(String name, int age, String gender, int salary){
        super(name, age, gender);
        this.salary = salary;
    }
    public Employer(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.salary = -1;
    }
    void setName(String name){
        this.name = name;
    }
    void setSalary(int salary){
        this.salary = salary;
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
    int getSalary(){
        return this.salary;
    }
    int getID(){
        return super.id;
    }

    public void work(){
        IO.println(name + "is working");
    }

    @Override
    public String toString() {
        return "Employer Name:'"+ getName() +"', age:'"+ getAge() +"', gender:'"+ getGender() +"', salary:'"+ getSalary() +"'";
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
