package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a savings account that doesn't allow checks. */
public class SavingsAccount extends BankAccount {
  private boolean isActive = true;

  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  protected boolean isClosed() {
    throw new IllegalStateException("Cannot check if account is closed");
  }

  @Override
  public boolean isActive() {
    return true;
  }

  public void closeAccount() {
    throw new IllegalStateException("Cannot close account with a positive balance");
  }
}
