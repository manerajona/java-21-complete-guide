package com.manerajona.java.programming.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();

        // Lambda only can be used with interfaces that contain only one method (functional interfaces)
        // @FunctionalInterface
        // Lambda structure: (Argument list) -> {body}
        Runnable runnable = () -> {
            String mje = "Printed from Lambda";
            System.out.println(mje);
        };
        new Thread(runnable).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        // Comparator
        // It infers the type Employee for e1 and e2
        // It infers that the last line (in this case the first also) is the return int
        Comparator<Employee> employeeComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
        employees.sort(employeeComparator);

        // Map and ForEach
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        // Create a lambda
        // It infers the type String for s1 and s2
        // It infers that the last line (in this case the first also) is the return String
        // In case of having curly braces semicolons and returns are mandatory
        UpperConcat upperConcat = (s1, s2) -> s1.toUpperCase().concat(s2.toUpperCase());
        String sillyString = doStringStuff(upperConcat, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        String s = new AnotherClass().doSomething();
        System.out.println(s);
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printed from CodeToRun run()");
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        System.out.println("The Another class's name is " + getClass().getSimpleName());
        String s;
        int i = 0;
        // Nested block
        UpperConcat upperConcat = (s1, s2) -> {
            System.out.println("The lambda class'n name is" + getClass().getSimpleName());
            // i++ you can't modify
            System.out.println("i lambda expression is " + i);
            return s1.toUpperCase().concat(s2.toUpperCase());
        };
        s = LambdaExpressions.doStringStuff(upperConcat, "String 1", "String 2");
        return s;
    }
}

class Employee {
    private String name;
    private int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}