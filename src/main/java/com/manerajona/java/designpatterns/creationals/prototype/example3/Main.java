package com.manerajona.java.designpatterns.creationals.prototype.example3;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John",
                new Address("123 London Road", "London", "UK"));
        //Employee chris = john;
        Employee chris = new Employee(john);

        chris.setName("Chris");
        System.out.println(john);
        System.out.println(chris);
    }
}