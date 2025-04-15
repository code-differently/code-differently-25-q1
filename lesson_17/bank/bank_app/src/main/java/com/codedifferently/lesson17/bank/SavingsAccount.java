package com.codedifferently.lesson17.bank;

import java.util.Set;

public class SavingsAccount extends Account {
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
  
}