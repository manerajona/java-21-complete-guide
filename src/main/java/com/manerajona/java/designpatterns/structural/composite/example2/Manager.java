package com.manerajona.java.designpatterns.structural.composite.example2;

import java.util.ArrayList;
import java.util.List;

class Manager implements Employee {

    private final List<Employee> employeeList = new ArrayList<>();
    private final String name;
    private final double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("[Start] Manager Details");
        System.out.println("\tName =" + getName());
        System.out.println("\tSalary =" + getSalary());
        System.out.println("\tEmployees in charge:");
        employeeList.forEach(Employee::showEmployeeDetails);
        System.out.println("[End] Manager Details");
    }

    public Employee getChild(int i) {
        return employeeList.get(i);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}
