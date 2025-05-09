package com.codedifferently.lesson28.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "guests")
public class LibraryGuestModel {
  public String type;
  public String name;
  @Id public String email;

  @OneToMany(mappedBy = "email", fetch = FetchType.EAGER)
  public List<CheckoutModel> checkedOutItems;
}
