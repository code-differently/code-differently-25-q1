package com.codedifferently.lesson17.bank;

import java.util.Set;

/** A savings account does not support checks. */
public class SavingsAccount extends BankAccount {

  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  // No check support = no extra method needed!
}
