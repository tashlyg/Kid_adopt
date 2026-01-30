package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Adopter extends Human{
    public Adopter(String name, int age, String gender){
        super(name, age, gender);
    }
    public Adopter(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
    }

    void setName(String name){
        this.name = name;
    }
    void setGender(String gender){
        this.gender = gender;
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
    int getID(){
        return super.id;
    }

    public void insertAdopter(Connection conn, String name, int age, String gender) {
        String sql = "INSERT INTO adopter (adopter_name, adopter_age, adopter_gender) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectAdopter(Connection conn) {
        String sql = "SELECT adopter_name, adopter_age, adopter_gender FROM adopter";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                IO.println(
                        rs.getString("adopter_name") +  "\t" +
                                rs.getInt("adopter_age") +  "\t" +
                                rs.getString("adopter_gender")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Adopter Name:'"+ name +"', age:'"+age+"', gender:'"+gender+"'";
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
