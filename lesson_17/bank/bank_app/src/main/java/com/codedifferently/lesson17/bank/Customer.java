package com.codedifferently.lesson17.bank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Represents a customer of the bank. */
public class Customer {

  static boolean isBusinessStatic() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  private final UUID id;
  private final String name;
  private final Set<BankAccount> accounts = new HashSet<>();
  private final boolean isBusiness;

  /**
   * Creates a new customer.
   *
   * @param id The ID of the customer.
   * @param name The name of the customer.
   */
  public Customer(UUID id, String name, boolean isBusiness) {
    this.id = id;
    this.name = name;
    this.isBusiness = isBusiness;
  }

  /**
   * Gets the ID of the customer.
   *
   * @return The ID of the customer.
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the name of the customer.
   *
   * @return The name of the customer.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a checking account to the customer. Checks if this is a business
   *
   * @return True if this is a business, otherwise false.
   */
  public boolean isBusiness() {
    return isBusiness;
  }

  /**
   * Adds an account to the customer.
   *
   * @param checkingAccount2 The account to add.
   */
  public void addAccount(BankAccount account) {
    accounts.add(account);
  }

  /**
   * Gets the accounts owned by the customer.
   *
   * @return The unique set of accounts owned by the customer.
   */
  public Set<BankAccount> getAccounts() {
    return accounts;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Customer other) {
      return id.equals(other.id);
    }
    return false;
  }

  @Override
  public String toString() {
    return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
