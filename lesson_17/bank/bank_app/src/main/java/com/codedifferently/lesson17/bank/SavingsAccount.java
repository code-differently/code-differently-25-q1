package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a savings account. */
public class SavingsAccount extends BankAccount {

  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  /**
   * Gets the account number.
   *
   * @return The account number.
   */
  public void depositFunds(Check check) {
    throw new UnsupportedOperationException("Cannot withdraw from savings account.");
  }
}
