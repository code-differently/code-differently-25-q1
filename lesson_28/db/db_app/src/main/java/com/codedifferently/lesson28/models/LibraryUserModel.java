package com.codedifferently.lesson28.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "library_users")
public class LibraryUserModel {
    @Id
    @Column(name="user_id")
    private String userId;
    
    @Column(name="email")
    private String email;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="password")
    private String password; 
}
