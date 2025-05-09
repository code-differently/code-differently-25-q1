package com.codedifferently.lesson28.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_users")
public class LibraryUsersModel {

    public String email;
    public String firstName;
    public String lastName;
    public String passwordString;
    public String UUID;

}
