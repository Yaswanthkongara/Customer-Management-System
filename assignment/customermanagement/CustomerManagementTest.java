package com.assignment.customermanagement;

public class CustomerManagementTest {

    public static void main(String[] args) {
        CustomerOperations operations = new CustomerOperations();

        System.out.println("===== INITIAL CUSTOMERS =====");
        displayCustomers(operations);

        System.out.println("\n===== ADD CUSTOMER =====");
        boolean added = operations.addCustomer(106, "Ananya", "Verma", 'F');
        System.out.println("Customer 106 added: " + added);

        System.out.println("\n===== ADD DUPLICATE CUSTOMER =====");
        boolean duplicateAdded = operations.addCustomer(106, "Ananya", "Verma", 'F');
        System.out.println("Duplicate customer added: " + duplicateAdded);

        System.out.println("\n===== UPDATE CUSTOMER 103 =====");
        boolean updated = operations.updateCustomer(103, "Arjun", "Reddy", 'M');
        System.out.println("Customer 103 updated: " + updated);
        System.out.println("Updated details: " + operations.findCustomerById(103));

        System.out.println("\n===== DELETE CUSTOMER 104 =====");
        boolean deleted = operations.deleteCustomer(104);
        System.out.println("Customer 104 deleted: " + deleted);

        System.out.println("\n===== FIND CUSTOMER BY ID 102 =====");
        Customer byId = operations.findCustomerById(102);
        System.out.println(byId != null ? byId : "Customer not found.");

        System.out.println("\n===== FIND CUSTOMER BY FIRST NAME KIRAN =====");
        Customer byFirstname = operations.findCustomerByFirstname("Kiran");
        System.out.println(byFirstname != null ? byFirstname : "Customer not found.");

        System.out.println("\n===== FIND CUSTOMER BY ID =====");
        Customer missing = operations.findCustomerById(105);
        if (missing != null) {
            System.out.println(missing);
        } else {
            System.out.println("Customer with ID 999 does not exist.");
        }

        System.out.println("\n===== CUSTOMERS AFTER ALL OPERATIONS =====");
        displayCustomers(operations);
    }

    private static void displayCustomers(CustomerOperations operations) {
        for (Customer customer : operations.getCustomers()) {
            System.out.println(customer);
        }
    }
}
