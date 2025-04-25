package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;

public interface Account {
  String getAccountNumber();

  Set<Customer> getOwners();

  void deposit(double amount);

  void withdraw(double amount) throws InsufficientFundsException;

  double getBalance();

  void closeAccount();

  boolean isClosed();
}
