package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    static void main() {
        String url = "jdbc:postgresql://localhost:5432/AdoptKidSystem";
        String user = "postgres";
        String password = "0294567890-=DM!";

        try {
            // Attempt to establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");

                Employer emp = new Employer();
                Kid kid = new Kid();
                Adopter adopter = new Adopter();
                Manager manager = new Manager();
                Shelter shelter = new Shelter();

                //emp.insertEmployer(connection, "Alice", 32, "Female", 1000);
                //kid.insertKid(connection, "Fatima Copeland", 7, "Female", "Healthy");
                //kid.insertKid(connection,"Keegan Lu", 10, "Male", "He doesn't have left arm");
                //adopter.insertAdopter(connection,"Briar Morrow", 30, "Female");
                //adopter.insertAdopter(connection,"Reyna Chang", 40, "Male");
                //manager.insertManager(connection,"Halo Malo", 40, "Female", 1000000);
                shelter.insertShelter(connection,"Det dom", "London", 14);

                IO.println("Employer************");
                emp.selectEmployer(connection);

                IO.println("Kid************");
                kid.selectKid(connection);

                IO.println("Adopter************");
                adopter.selectAdopter(connection);

                IO.println("Manager**************");
                manager.selectManager(connection);

                IO.println("Shelter**************");
                shelter.selectShelter(connection);
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

        Kid kid1 = new Kid("Fatima Copeland", 7, "Female", "Healthy");
        Kid kid2 = new Kid("Keegan Lu", 10, "Male", "He doesn't have left arm");
        Kid kid3 = new Kid("Benson Curtis", 14, "Male", "Brainroot");

        Shelter shelter1 = new Shelter("Det dom", "London", 14);
        Shelter shelter2 = new Shelter("Det dom", "London", 14);

        Employer employer1 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer2 = new Manager("Bob builder", 20, "Male", 100000);
        Employer employer3 = new Manager("Bob builder", 20, "Male", 100000);

        Manager manager1 = new Manager("Halo Malo", 40, "Female", 1000000);

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


