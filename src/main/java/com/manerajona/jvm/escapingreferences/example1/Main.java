package com.manerajona.jvm.escapingreferences.example1;

import com.manerajona.jvm.escapingreferences.example1.references.CustomerRecords;
import com.manerajona.jvm.escapingreferences.example1.references.customerImplementation.Customer;

import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();
		
		records.addCustomer("John");
		records.addCustomer("Simon");

		records.forEach(System.out::println);

		records.iterator().forEachRemaining(System.out::println);

		Iterator<Customer> it = records.iterator();
		it.next();
		it.remove();

		records.iterator().forEachRemaining(System.out::println);

		Customer customer = (Customer) records.find("John");
		System.out.println("Selected client is " + customer.getName());

		Map<String, Customer> customers = records.getCustomers();
		customers.values().forEach(v -> System.out.println(v.getName()));

	}
}