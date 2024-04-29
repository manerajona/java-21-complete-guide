package com.manerajona.java.designpatterns.structural.composite.example1;

public class Main {
    public static void main(String[] args) {
        // Create employee components
        Employee dev1 = new Developer(100, "Jason Fedin", "Pro Developer");
        Employee dev2 = new Developer(101, "Myra Fedin", "Entry level Developer");

        Employee man1 = new Manager(200, "Jennifer Fedin", "SEO Manager");
        Employee man2 = new Manager(201, "Ian Fedin", "Myra's Manager");

        // Create the engineers directory composite
        Directory engDirectory = new Directory();
        // Add developer leafs
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        // Create the management directory
        Directory accDirectory = new Directory();
        // Add manager leafs
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        // Create the company directory composite
        Directory companyDirectory = new Directory();
        // Add directory components
        companyDirectory.addEmployee(engDirectory);
        companyDirectory.addEmployee(accDirectory);

        // Show all company employees
        companyDirectory.showEmployeeDetails();
    }
}
