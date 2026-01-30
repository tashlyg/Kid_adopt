package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }
    public String getDisease(){
        return this.disease;
    }
    public int getID(){
        return super.id;
    }


    public void insertKid(Connection conn, String name, int age, String gender, String disease) {
        String sql = "INSERT INTO kid (kid_name, kid_age, kid_gender, kid_disease) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, disease);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectKid(Connection conn) {
        String sql = "SELECT kid_name, kid_age, kid_gender, kid_disease FROM kid";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                IO.println(
                        rs.getString("kid_name") +  "\t" +
                                rs.getInt("kid_age") +  "\t" +
                                rs.getString("kid_gender") +  "\t" +
                                rs.getString("kid_disease")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
