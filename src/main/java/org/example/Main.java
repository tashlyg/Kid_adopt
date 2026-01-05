package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Adopter adopter1 = new Adopter("Briar Morrow", 30, "Female");
        Adopter adopter2 = new Adopter("Reyna Chang", 40, "Male");

        Kid kid1 = new Kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new Kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new Kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new Shelter("Det dom", "London", 14);
        Shelter shelter2 = new Shelter("Det dom", "London", 14);

        Employer employer1 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer2 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer3 = new Manager("Bob builder", 20, "Male", 100000);

        Manager manager1 = new Manager("Halo Malo", 40, "Female", 1000000);

        IO.println(shelter1.getKid2());

        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new Adopter("Liay Bover", 25, "Male"));
        adopters.add(new Adopter("Key Man", 30, "Female"));
        adopters.add(new Adopter("Oh Men", 22, "Male"));
        adopters.add(new Adopter("Me Drom", 35, "Female"));
        adopters.add(new Adopter("You Kim", 28, "Male"));

        FilterManager<Adopter> manager = new FilterManager<>(adopters);

        IO.println("=== Male ppl ===");
        List<Adopter> MalePeople = manager.filter(p -> p.getGender().equals("Male"));
        MalePeople.forEach(System.out::println);
    }
}
