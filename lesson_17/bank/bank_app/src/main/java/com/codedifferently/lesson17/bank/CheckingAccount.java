package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a checking account. */
public class CheckingAccount extends BankAccount {

  private final Set<Customer> owners;
  private final String accountNumber;
  private double balance;
  private boolean isActive;

  /**
   * Creates a new checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    isActive = true;
  }

  @Override
  public String toString() {
    return "CheckingAccount{"
        + "accountNumber='"
        + accountNumber
        + '\''
        + ", balance="
        + balance
        + ", isActive="
        + isActive
        + '}';
  }
}
