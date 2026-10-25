package com.assignment.customermanagement;

import java.util.Objects;

public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private char gender;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, char gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) obj;
        return id == other.id
                && gender == other.gender
                && Objects.equals(firstname, other.firstname)
                && Objects.equals(lastname, other.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, gender);
    }

    @Override
    public String toString() {
        return "Customer[id=" + id
                + ", firstname=" + firstname
                + ", lastname=" + lastname
                + ", gender=" + gender + "]";
    }
}
