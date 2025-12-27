package org.example;

public class Manager extends Employer{
    private int teamSize;
    public Manager(String name, int age, String gender, int salary){
        super(name, age, gender, salary);
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