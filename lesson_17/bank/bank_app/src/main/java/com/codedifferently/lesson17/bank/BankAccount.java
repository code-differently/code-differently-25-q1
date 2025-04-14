package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/** Base class for all bank accounts. */
public abstract class BankAccount {
  private String accountNumber;
  private double balance;
  private Set<Customer> owners;

  public BankAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public Set<Customer> getOwners() {
    return owners;
  }

  public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient funds");
    }
    balance -= amount;
  }

  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    balance += amount;
  }
}
