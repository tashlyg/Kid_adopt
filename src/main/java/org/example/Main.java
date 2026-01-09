package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/AdoptKidSystem";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    private static void insertData(Connection conn, int id, String desc, double budget) throws SQLException {
        String query = "INSERT INTO job_listing (id, description, budget) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.setString(2, desc);
            pst.setDouble(3, budget);
            pst.executeUpdate();
        }
    }

    private static List<String> selectData(Connection conn) throws SQLException {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM job_listing";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                results.add(rs.getInt("id") + " - " + rs.getString("description") + ": " + rs.getDouble("budget"));
            }
        }
        return results;
    }

    private static void updateData(Connection conn, int id, double newBudget) throws SQLException {
        String query = "UPDATE job_listing SET budget = ? WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setDouble(1, newBudget);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
    }

    private static void deleteData(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM job_listing WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
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

        // test sql hahaha
        try {
            Class.forName("org.postgresql.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

                insertData(conn, 10, "Mobile App Dev", 3000.00);
                insertData(conn, 20, "Logo Design", 200.00);

                List<String> data = selectData(conn);
                for (String s : data) System.out.println(s);

                updateData(conn, 10, 3500.00);

                deleteData(conn, 20);

                System.out.println("--- Final State ---");
                selectData(conn).forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


