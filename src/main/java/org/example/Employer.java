package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employer extends Human{
    int salary;
    String shelter;
    public Employer(String name, int age, String gender, int salary){
        super(name, age, gender);
        this.salary = salary;
    }
    public Employer(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.salary = -1;
    }
    void setName(String name){
        this.name = name;
    }
    void setSalary(int salary){
        this.salary = salary;
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
    int getSalary(){
        return this.salary;
    }
    int getID(){
        return super.id;
    }

    public void work(){
        IO.println(name + "is working");
    }


    public void insertEmployer(Connection conn, String name, int age, String gender, int salary) {
        String sql = "INSERT INTO employer (employer_name, employer_age, employer_gender, employer_salary) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, salary);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s).");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectEmployer(Connection conn) {
        String sql1 = "SELECT employer_name, employer_age, employer_gender, employer_salary FROM employer";

        try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                IO.println(
                        rs.getString("employer_name") +  "\t" +
                        rs.getInt("employer_age") +  "\t" +
                        rs.getString("employer_gender") +  "\t" +
                        rs.getInt("employer_salary")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Employer Name:'"+ getName() +"', age:'"+ getAge() +"', gender:'"+ getGender() +"', salary:'"+ getSalary() +"'";
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
