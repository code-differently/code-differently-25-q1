package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a savings account. */
public class SavingsAccount extends Account {

  /**
   * Creates a new sacings account.
   *
   * @param accountNumber The account number.
   * @param owners The ownders of the account.
   * @param initalBalance The inital balance of the account.
   */
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initalBalance) {
    super(accountNumber, owners, initalBalance);
  }

  @Override
  public String toString() {
    return "SavingsAccount{"
        + "accountNumber='"
        + getAccountNumber()
        + '\''
        + ", balance="
        + getBalance()
        + ", isActive="
        + isActive()
        + '}';
  }
}
