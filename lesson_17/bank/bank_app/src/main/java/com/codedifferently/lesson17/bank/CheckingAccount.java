package com.codedifferently.lesson17.bank;

import lombok.Getter;

import java.util.Set;

/** Represents a checking account. */
@Getter
public class CheckingAccount extends Account {

  /**
   * Creates a new checking account.
   *
   * @param accountNumber  The account number.
   * @param owners         The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  @Override
  public String toString() {
    return "CheckingAccount{"
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
