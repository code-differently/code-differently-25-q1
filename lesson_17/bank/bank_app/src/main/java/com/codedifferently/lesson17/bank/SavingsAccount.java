package com.codedifferently.lesson17.bank;

import java.util.Set;

public class SavingsAccount extends CheckingAccount {
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  @Override
  public void withdraw(double amount) {
    String method = null;
    if ("check".equalsIgnoreCase(method)) {
      throw new UnsupportedOperationException("Cannot withdraw checks from the savings account");
    }

    this.balance += amount;
  }
}
