package com.manerajona.jvm.leaks.example2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class CustomerManager {

	private final List<Customer> customers = new ArrayList<Customer>();
	private int nextAvailableId = 0;
	
	public  void addCustomer(Customer customer) {
		synchronized (this) {
			customer.setId(nextAvailableId);
			synchronized(customers) {
				customers.add(customer);
			}
			nextAvailableId++;
		}

	}

	public Optional<Customer> getNextCustomer() {
		synchronized(customers) {
				if (customers.size() > 0) {
					return Optional.of(customers.get(0));
				}
		}
		return Optional.empty();
	}	

	public void howManyCustomers() {
		int size = 0;
		size = customers.size();
		System.out.println("" + new Date() + " Customers in queue : " + size + " of " + nextAvailableId);
	}

}
