package com.codedifferently.lesson28.models;

public class LibraryUserModel {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Integer phoneNUmber;

    public LibraryUserModel(String id, String email, String firstName, String lastName, String password, Integer phoneNUmber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this .phoneNUmber = phoneNUmber;
    }
}
