package com.codedifferently.lesson17.bank;

import java.util.Set;
import java.util.UUID;

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

  public String getAccountNumber() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAccountNumber'");
  }

  public Map<UUID getOwners() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOwners'");
  }

  @Override
  protected boolean isClosed() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isClosed'");
  }
}
