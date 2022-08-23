package server.controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDataManager {
	
	private List<Customer> customers;
	
	/**
	 * Constructor
	 */
	public CustomerDataManager() {
		
		// Load customers
		this.customers = new ArrayList<Customer>();
		this.loadCustomer();
		
	}
		
	/**
	 * This method loads a list of product into a list
	 */
	private void loadCustomer() {
			
		// Sample data
		int custIds[] = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
		String custNames[] = {"Anbu", "Selvi", "Mina", "Wani", "Hidayah", "Weddy", "Nisha", "Noah", "Ravi", "Shangkar"};
				
		// Load data into list
		for (int index=0; index < custIds.length; index++) {
					
		// Create customer
		Customer customer = new Customer();
		customer.setCustomerId(custIds[index]);
		customer.setCustName(custNames[index]);
		
		// Add to list
		customers.add(customer);
		}
	
	}
	
	/**
	 * This method finds a customer from a list based on the customer name
	 * and return a customer
	 * @param name
	 * @return a customer
	 */
	public Customer getCustomerName(String name) {
		
		// Find a customer
		for (Customer customer:customers) {
			if (customer.getCustName().equals(name))
				return customer;
		}
		
		// Return customer not found
		Customer unFoundCustomer = new Customer();
		unFoundCustomer.setCustName("Customer not found");
		
		return unFoundCustomer;
	}
	
	/**
	 * This method finds a customer from a list based on the customer id
	 * and return a customer
	 * @param id
	 * @return a customer
	 */
	public Customer getCustomer(int custId) {
		
		// Find a customer
		for (Customer customer:customers) {
			
			if (customer.getCustomerId() == custId)
				return customer;
		}
		
		// Return customer not found
		Customer unFoundCustomer = new Customer();
		unFoundCustomer.setCustName("Customer not found");
		
		return unFoundCustomer;
	}
	
	/**
	 * This method returns a list of customers
	 */
	public List<Customer> getCustomers() {
		
		return customers;
	}

}
