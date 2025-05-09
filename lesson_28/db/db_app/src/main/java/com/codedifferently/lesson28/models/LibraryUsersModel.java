package com.codedifferently.lesson28.models;

public class LibraryUsersModel {
    public String email;
    public String firstName;
    public String lastName;
    public String passwordString;
    public String UUID;

    public LibraryUserModel(String email, String firstName, String lastName, String passwordString, String UUID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordString = passwordString;
        this.UUID = UUID;

        
    }
}
