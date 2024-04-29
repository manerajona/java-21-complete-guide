package com.manerajona.java.designpatterns.structural.composite.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite Directory
 */
class Directory implements Employee {

    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        employeeList.forEach(Employee::showEmployeeDetails);
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}
