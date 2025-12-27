package org.example;

public class Kid extends Human{
    String disease;
    public Kid(String name, int age, String gender, String disease){
        super(name, age, gender);
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


    @Override
    public String toString() {
        return "Kid Name:'"+ name +"', age:'"+age+"', gender:'"+gender+"', disease:'"+disease+"'";
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
