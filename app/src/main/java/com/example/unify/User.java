package com.example.unify;

public class User {
    private final String firstName;
    private final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    // Initiale du participant
    public String getFirstLetter() {
        return String.valueOf(this.firstName.charAt(0));
    }

}
