package org.example;

public class Person {

    // Fields
    private int id;

    private String firstName;

    private String lastName;

    private String email;


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
        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email adress can not be null");
        }
        this.email = email;
    }


    // Methods

    public String getSummary () {
        return new String("id: " + id +
                ", name: " + firstName + lastName +
                ", email: " + email);
    }
}
