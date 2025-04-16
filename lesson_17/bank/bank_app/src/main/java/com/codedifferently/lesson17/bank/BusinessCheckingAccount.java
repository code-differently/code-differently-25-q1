package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a business checking account. */
public class BusinessCheckingAccount extends BankAccount {

  /**
   * Creates a new business checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
