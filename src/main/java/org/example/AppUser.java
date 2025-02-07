package org.example;

import java.util.Objects;

public class AppUser extends Person {

    private String username;

    private String password;

    private AppRole role;



    // CONSTRUCTOR
    public AppUser(String firstName, String lastName, String email, String username, String password, AppRole role) {
        super(firstName, lastName, email);
        setUsername(username);
        setPassword(password);
        setRole(role);
        setCredentials(this);
    }

    // GETTERS
    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public AppRole getRole() {
        return role;
    }


    // SETTERS
    public void setUsername(String username) {
        Objects.requireNonNull(username, "No username given, therefore no user created. Try again");
        if (username.trim().isEmpty()) throw new IllegalArgumentException("Username Missing");
        this.username = username;
    }

    public void setPassword(String password) {
        Objects.requireNonNull(password, "No password given, therefore no user created. Try again");
        if (password.trim().isEmpty()) throw new IllegalArgumentException("Password Missing");
        this.password = password;
    }

    public void setRole(AppRole role) {
        Objects.requireNonNull(role, "Role is either empty or not a valid option, therefore no user created. Try again");
        this.role = role;
    }


    // METHODS
    @Override
    public String toString() {
        return "Username: " + username +
                "\nRole: " + role +
                "\n" + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role, super.hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        AppUser appUser = (AppUser) object;
        return Objects.equals(username, appUser.username)
                && Objects.equals(role, appUser.role)
                && super.equals(object);
    }


}
