package com.codedifferently.lesson17.bank;

import java.util.Set;

public class BusinessCheckingSavingsAccount extends CheckingAccount {
  public BusinessCheckingSavingsAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
