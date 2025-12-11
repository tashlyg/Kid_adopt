package org.example;

class kid{
    int age;
    String gender;
    String disease;
}
class adopter{
    int age;
    String gender;
}
class shelter{
    String name;
    String location;
}

public class Main {
    static void main() {
        IO.println("Hello world!");

        adopter adopter1 = new adopter();
        adopter adopter2 = new adopter();

        kid kid1 = new kid();
        kid kid2 = new kid();
        kid kid3 = new kid();

        shelter shelter1 = new shelter();

        adopter1.age = 30;
        adopter1.gender = "Female";
        adopter1.age = 30;
        adopter1.gender = "Male";

        int i = 1;
        IO.println("i = " + i);
    }
}
