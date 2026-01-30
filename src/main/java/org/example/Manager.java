package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends Employer{
    private int teamSize;
    public Manager(String name, int age, String gender, int salary){
        super(name, age, gender, salary);
    }
    public Manager(){
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.salary = -1;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if(teamSize < 0){
            throw new IllegalArgumentException("Team size cant be negative");
        }
        this.teamSize = teamSize;
    }

    public void insertManager(Connection conn, String name, int age, String gender, int salary) {
        String sql = "INSERT INTO manager (manager_name, manager_age, manager_gender, manager_salary) VALUES (?, ?, ?, ?)";

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
    public void selectManager(Connection conn) {
        String sql1 = "SELECT manager_name, manager_age, manager_gender, manager_salary FROM manager";

        try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                IO.println(
                        rs.getString("manager_name") +  "\t" +
                                rs.getInt("manager_age") +  "\t" +
                                rs.getString("manager_gender") +  "\t" +
                                rs.getInt("manager_salary")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Manager Name:'"+ getName() +"', age:'"+getAge()+"', gender:'"+getGender()+"', salary:'"+getSalary()+"', teamSize:"+getTeamSize()+"'";
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