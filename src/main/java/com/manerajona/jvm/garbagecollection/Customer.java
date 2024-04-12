package com.manerajona.jvm.garbagecollection;

public class Customer  {

	private String name;

	public String getName() {
		return name;
	}
	
	public Customer(String name) {
		this.name = name;
	}
	
	public Customer(Customer oldCustomer) {
		this.name = oldCustomer.name; 
	}

	public String toString() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void finalize() {
		System.out.println("This object is being g.c.'d " + name);
		while(true) {
			
		}
	}
	
}