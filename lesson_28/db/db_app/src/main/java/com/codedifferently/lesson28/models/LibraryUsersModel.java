package com.codedifferently.lesson28.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "library_users")
public class LibraryUsersModel {
  @Id public UUID id;

  public String email;
  public String firstName;
  public String lastName;
  public String passwordString;
}
