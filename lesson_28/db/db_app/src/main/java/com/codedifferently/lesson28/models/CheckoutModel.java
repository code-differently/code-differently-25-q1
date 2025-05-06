package com.codedifferently.lesson28.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "checked_out_items")
public class CheckoutModel {
  @Id public UUID itemId;
  public String email;
  public Instant dueDate;
}
