package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a business checking account. */
public class BusinessCheckingAccount extends CheckingAccount {
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
  /**
   * Gets the account number.
   *
   * @return The account number.
   */
}
