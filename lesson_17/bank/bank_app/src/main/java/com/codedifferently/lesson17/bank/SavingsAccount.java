package com.codedifferently.lesson17.bank;

import java.util.Set;




public class SavingsAccount extends CheckingAccount {
    
  /**
   * Represents a savings account.
   *
   * <p>It is a subclass of CheckingAccount and inherits its properties and methods.
   */



public SavingsAccount (String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
  
  public void depositFunds(Check check) {
   throw new UnsupportedOperationException("Cannot deposit check into a savings account");
}
}
