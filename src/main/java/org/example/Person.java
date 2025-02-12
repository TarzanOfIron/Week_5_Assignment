package org.example;

import Sequencers.PersonalIdSequencer;

import java.util.Objects;

public class Person {

    // Fields
    //private static int sequencer = 0;

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private AppUser credentials;


    // Constructors

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId();
    }


    // Getters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    // Setters

    public void setFirstName(String firstName) {
        if (firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name can not be null");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name can not be null");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredentials(AppUser credentials) {
        Objects.requireNonNull(credentials, "You need to assign to a user");
        this.credentials = credentials;
    }

    private void setId() {
        this.id = PersonalIdSequencer.nextId();
    }

    // Methods
    // Override methods
    @Override
    public String toString() {
        return //"id: " + id +
                "Name: " + firstName + " " + lastName +
                        "\nEmail: " + email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Person newPerson = (Person) obj;
        return Objects.equals(id, newPerson.id) &&
                Objects.equals(firstName, newPerson.firstName) &&
                Objects.equals(lastName, newPerson.lastName) &&
                Objects.equals(email, newPerson.email);
    }
}
