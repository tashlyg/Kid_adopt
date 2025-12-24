package org.example;

public class Manager extends Employer{
    int teamSize;
    public Manager(String name, int age, String gender, int salary, int teamSize){
        super(name, age, gender, salary);
        this.teamSize = teamSize;
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

    @Override
    public String toString() {
        return "MANAGER Name:'"+ name +"', age:'"+age+"', gender:'"+gender+"', salary:'"+salary+"', teamSize:"+teamSize+"'";
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