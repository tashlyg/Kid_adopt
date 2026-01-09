package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresApp {
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
}
