package com.codedifferently.lesson17.bank;

import java.util.Set;

public class CheckingAccount extends BankAccount {

  /**
   * Creates a new saving account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   * @return
   */
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
