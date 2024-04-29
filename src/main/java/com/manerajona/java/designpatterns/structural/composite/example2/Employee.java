package com.manerajona.java.designpatterns.structural.composite.example2;

interface Employee {
    void showEmployeeDetails();
}

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
        return "\tDeveloper{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", position='" + position + '\'' +
                '}';
    }
}