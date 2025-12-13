package org.example;

import java.util.Objects;

public class Main {
    static void main() {
        Adopter adopter1 = new Adopter("Briar Morrow", 30, "Female");
        Adopter adopter2 = new Adopter("Reyna Chang", 40, "Male");

        Kid kid1 = new Kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new Kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new Kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new Shelter("Det dom", "London", 14);

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
