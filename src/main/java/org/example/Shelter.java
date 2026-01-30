package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shelter extends BaseShelters{
    private int id;
    String name;
    String location;
    int places;

    public Shelter(String name, String location, int places){
        this.name = name;
        this.location = location;
        this.places = places;
    }
    public Shelter(){
        this.name = "unknown";
        this.location = "unknown";
        this.places = -1;
    }
    void setName(String name){
        this.name = name;
    }
    void setPlaces(int places){
        this.places = places;
    }

    String getName(){
        return this.name;
    }
    String getLocation(){
        return this.location;
    }
    int getPlaces(){
        return this.places;
    }
    int getID(){
        return super.id;
    }

    public void insertShelter(Connection conn, String name, String location, int places) {
        String sql = "INSERT INTO shelter (shelter_name, shelter_location, shelter_places) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, location);
            pstmt.setInt(3, places);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectShelter(Connection conn) {
        String sql = "SELECT shelter_name, shelter_location, shelter_places FROM shelter";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                IO.println(
                        rs.getString("shelter_name") +  "\t" +
                                rs.getString("shelter_location") +  "\t" +
                                rs.getInt("shelter_places")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Shelter Name:'"+ name +"', location:'"+location+"', places:'"+places+"'";
    }
}