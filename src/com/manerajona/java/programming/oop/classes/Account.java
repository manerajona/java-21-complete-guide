package com.manerajona.java.programming.oop.classes;

public class Account {
    private String number;
    private Double balance;
    private String customerName;
    private String email;
    private String phone;

    public Account() {
        this("00000000", "Default customer"); // Way of calling a constructor inside the class
        this.balance = .0d;
    }

    public Account(String number, String customerName) {
        setNumber(number); // Alternative using sets, but is not good practice to call another method in constructor
        setCustomerName(customerName);
    }

    public Account(String number, Double balance, String customerName, String email, String phone) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposit of %.2f processed. New balance: %.2f\n", amount, this.balance);
    }

    public void withdrawal(double amount) {
        if((this.balance - amount) < .0d ) {
            System.out.printf("Your withdrawal was not processed. Check your balance: %.2f\n", this.balance);
        } else {
            this.balance -= amount;
            System.out.printf("Withdrawal of %.2f processed. Remaining balance: %.2f\n", amount, this.balance);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
