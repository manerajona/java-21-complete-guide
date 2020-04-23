package com.manerajona.java.programming.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PredicatesAndSuppliers {
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

        // Predicates (return true or false)
        Predicate<Employee> employeePredicate1 = employee -> employee.getAge() > 30;
        printEmployeesByAge(employees, "Employees over 30", employeePredicate1);

        Predicate<Employee> employeePredicate2 = employee -> employee.getAge() <= 30;
        printEmployeesByAge(employees, "\nEmployees 30 and under", employeePredicate2);

        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        // Int predicates
        IntPredicate greaterThan15 = i -> i > 15;
        boolean result = greaterThan15.test(10);
        System.out.println(result);
        int a = 20;
        result = greaterThan15.test(a + 5);
        System.out.println(result);

        // Combine predicates
        IntPredicate lessThan100 = i -> i < 100;
        result = greaterThan15.and(lessThan100).test(50);
        System.out.println(result);
        result = greaterThan15.and(lessThan100).test(15);
        System.out.println(result);

        // Supplier (does't accept parameters)
        Random random = new Random();

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

        IntFunction<Integer> integerIntFunction = i -> randomSupplier.get();
        IntStream.range(0, 10).mapToObj(integerIntFunction).forEach(System.out::println);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==================");
        employees.stream().filter(ageCondition).map(Employee::getName).forEach(System.out::println);
    }
}
