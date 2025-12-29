package org.example;

import java.util.Objects;

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
    int getID(){
        return super.id;
    }

    @Override
    public String toString() {
        return "Kid Name:'"+ name +"', age:'"+age+"', gender:'"+gender+"', disease:'"+disease+"'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kid that = (Kid) o;
        return id == that.id && that.name.compareToIgnoreCase(name) == 0 && Objects.equals(age, that.age) && that.gender.compareToIgnoreCase(gender) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, disease);
    }
}
