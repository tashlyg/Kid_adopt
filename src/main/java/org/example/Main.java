package org.example;

import java.util.Objects;

public class Main {
    static void main() {
        Adopter adopter1 = new Adopter("Briar Morrow", 30, "Female");
        Adopter adopter2 = new Adopter("Reyna Chang", 40, "Male");

        Human kid1 = new Kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new Kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new Kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new Shelter("Det dom", "London", 14);

        Employer employer1 = new Employer("Bob builder", 20, "Male", 100000);

        Manager manager1 = new Manager("Halo Malo", 40, "Female", 100000, 10);
        IO.println(kid1 +"\n" + kid2 + "\n" + kid3 + "\n" + shelter1 +"\n"+employer1+"\n"+manager1);
    }
}
