package com.codedifferently.lesson17.bank;

import java.util.Set;

public class BusinessCheckingAccount extends BankAccount {
  private final boolean isBusiness;

  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance, boolean isBusiness) {
    super(accountNumber, owners, initialBalance);
    this.isBusiness = isBusiness;
  }

  public boolean isBusiness() {
    return isBusiness;
  }
}
