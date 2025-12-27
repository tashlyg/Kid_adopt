package org.example;

import java.util.Objects;

public class Main {
    static void main() {
        Adopter adopter1 = new Adopter("Briar Morrow", 30, "Female");
        Adopter adopter2 = new Adopter("Reyna Chang", 40, "Male");

        Kid kid1 = new Kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new Kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new Kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new Shelter("Det dom", "London", 14, kid1); // doest have ID

        Employer employer1 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer2 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer3 = new Manager("Bob builder", 20, "Male", 100000);

        Manager manager1 = new Manager("Halo Malo", 40, "Female", 1000000);

        IO.println(kid1 +"\n" + kid2 + "\n" + adopter1 + "\n" + shelter1 +"\n"+employer1+"\n"+manager1);
        IO.println(adopter1.getID());
        IO.println(employer1.getID());
        IO.println(employer2.getID());
        IO.println(employer3.getID());
    }
}
