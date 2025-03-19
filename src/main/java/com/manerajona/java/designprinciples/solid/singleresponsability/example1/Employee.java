package com.manerajona.java.designprinciples.solid.singleresponsability.example1;

import java.util.Date;

class Employee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

    // FIXME this method violates single responsibility principle
    public boolean isPromotionDueThisYear() {
        // promotion logic implementation is using the employee information passed in
        return true;
    }

    // FIXME this method violates single responsibility principle
    public double calcIncomeTaxForCurrentYear(Employee emp) {
        // income tax logic using employee passed in
        return 0.0;
    }

    // getters / setters for all member variables
}