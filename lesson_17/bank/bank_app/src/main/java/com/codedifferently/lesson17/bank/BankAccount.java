package com.codedifferently.lesson17.bank;

import java.util.HashSet;
import java.util.Set;

public abstract class BankAccount {
  protected String accountNumber;
  protected Set<Customer> owners;
  protected double balance;
  protected boolean closed;

  public BankAccount(String accountNumber, Customer owner) {
    this.accountNumber = accountNumber;
    this.owners = new HashSet<>(Set.of(owner));
    this.balance = 0.0;
    this.closed = false;
    owner.addAccount(this);
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public Set<Customer> getOwners() {
    return owners;
  }

  public double getBalance() {
    return balance;
  }

  public boolean isClosed() {
    return closed;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void closeAccount() {
    closed = true;
  }
}
