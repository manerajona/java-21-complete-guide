package com.manerajona.java.designpatterns.structural.composite.example1;

/**
 * Directory Component: Employee
 */
interface Employee {
    void showEmployeeDetails();
}

/**
 * Employee Leaf: Developer
 */
class Developer implements Employee {

    private final String name;
    private final long empId;
    private final String position;

    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", position='" + position + '\'' +
                '}';
    }
}

/**
 * Employee Leaf: Manager
 */
class Manager implements Employee {

    private final String name;
    private final long empId;
    private final String position;

    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", position='" + position + '\'' +
                '}';
    }
}
