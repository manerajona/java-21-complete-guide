package com.manerajona.java.programming.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // Flat Map
        departments.stream()
                /*
                    Returns a stream consisting of the results of replacing each element of
                    this stream with the contents of a mapped stream produced by applying
                    the provided mapping function to each element.
                 */
                .flatMap(department -> department.getEmployees().stream())
                .forEach(employee -> System.out.println(employee.getAge()));

        System.out.println("---------------");

        // Collector
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);    // Runtime can create a new, add one or add many

        sortedGNumbers.forEach(System.out::println);

        System.out.println("---------------");

        // Other cases
        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));

        groupedByAge.forEach((integer, employees) -> employees.forEach(employee -> System.out.println(integer +"-"+ employee.getName())));

        System.out.println("---------------");

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(employee -> System.out.println(employee.getName()));

        System.out.println("---------------");

        long count = Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}

