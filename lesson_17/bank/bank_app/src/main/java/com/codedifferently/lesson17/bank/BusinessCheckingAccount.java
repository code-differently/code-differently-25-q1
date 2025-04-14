package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InvalidBusinessAccountException;

public class BusinessCheckingAccount extends CheckingAccount {
  public BusinessCheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);

    boolean hasBusinessOwner = owners.stream().anyMatch(Customer::isBusiness);
    if (!hasBusinessOwner) {
      throw new InvalidBusinessAccountException("At least one owner must be a business.");
    }
  }
}