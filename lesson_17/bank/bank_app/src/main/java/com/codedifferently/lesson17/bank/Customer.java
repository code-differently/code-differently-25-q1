package com.codedifferently.lesson17.bank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** Represents a customer of the bank */
public class Customer {

  private final UUID id;
  private final String name;
  private final CustomerType type;
  private final Set<Account> accounts = new HashSet<>();

  /**
   * Creates a new customer.
   *
   * @param id The ID of the customer.
   * @param name The name of the customer.
   * @param type The type of customer (individual or business)
   */
  public Customer(UUID id, String name, CustomerType type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  /**
   * Creates a new individual customer. *
   *
   * @param id The ID of the customer.
   * @param name The name of the customer.
   * @param type The type of customer (individual or business) / public Customer(UUID id, String
   *     name) { this.id = id; this.name = name; this.type = CustomerType. INDIVIDUAL; }
   *     <p>/** Adds a checking account to the customer.
   * @param account The account to add.
   */
  public void addAccount(Account account) {
    accounts.add(account);
  }

  /**
   * Gets the accounts owned by the customer.
   *
   * @return The set of accounts owned by the customer. / public Set<Account> getAccounts() { return
   *     accounts; }
   *     <p>/** Checks if the owner is a business.
   * @return True if the customer is a business, false otherwise.
   */
  public boolean isBusiness() {
    return this.type == CustomerType.BUSINESS;
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
    return "Customer" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
