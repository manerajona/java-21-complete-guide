package com.manerajona.java.programming.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Functions {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        Function<Employee, String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1);
        Function<Employee, String> getFirstName = employee -> employee.getName().substring(0, employee.getName().indexOf(' '));

        employees.forEach(employee -> {
            System.out.print("First Name: "+getAName(getFirstName, employee));
            System.out.print(", ");
            System.out.println("Last Name: "+getAName(getLastName, employee));
        });

        // Composed functions
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> concatenate = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(concatenate);
        employees.forEach(employee -> System.out.println(chainedFunction.apply(employee)));

        // Bi-Function
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> name.concat(" " + employee.getAge());

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        // Int Unary Operator
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        // Consumer (do not return values)
        Consumer<String> c1 = String::toUpperCase;
        Consumer<String> c2 = System.out::println;
        c1.andThen(c2).accept("Hello, World!");
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }
}

