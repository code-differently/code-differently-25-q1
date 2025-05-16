package com.codedifferently.lesson28.models;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "checked_out_items")
public class CheckoutModel {
  @Id public UUID itemId;
  public String email;
  public Instant dueDate;
}
