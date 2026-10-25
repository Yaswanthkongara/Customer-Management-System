package com.assignment.customermanagement;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerOperations {
    private final HashSet<Customer> customers = new HashSet<>();

    public CustomerOperations() {
        customers.add(new Customer(101, "Rahul", "Sharma", 'M'));
        customers.add(new Customer(102, "Priya", "Reddy", 'F'));
        customers.add(new Customer(103, "Arjun", "Kumar", 'M'));
        customers.add(new Customer(104, "Sneha", "Rao", 'F'));
        customers.add(new Customer(105, "Kiran", "Patel", 'M'));
    }

    public boolean addCustomer(int id, String firstname, String lastname, char gender) {
        Customer customer = new Customer(id, firstname, lastname, gender);
        return customers.add(customer);
    }

    public boolean updateCustomer(int customerId, String firstname, String lastname, char gender) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            return false;
        }

        // Remove before changing fields used by equals/hashCode.
        customers.remove(customer);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setGender(gender);
        customers.add(customer);
        return true;
    }

    public boolean deleteCustomer(int customerId) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId() == customerId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public HashSet<Customer> getCustomers() {
        // Return a copy so callers cannot directly modify the internal collection.
        return new HashSet<>(customers);
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public Customer findCustomerByFirstname(String firstname) {
        if (firstname == null) {
            return null;
        }
        for (Customer customer : customers) {
            if (firstname.equalsIgnoreCase(customer.getFirstname())) {
                return customer;
            }
        }
        return null;
    }
}
