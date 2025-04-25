package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;

public class SavingsAccount implements Account {

  private final Set<Customer> owners;
  private final String accountNumber;
  private double balance;
  private boolean isActive;

  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    this.isActive = true;
  }

  @Override
  public String getAccountNumber() {
    return accountNumber;
  }

  @Override
  public Set<Customer> getOwners() {
    return owners;
  }

  @Override
  public void deposit(double amount) {
    if (isClosed()) {
      throw new IllegalStateException("Cannot deposit to a closed account");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    balance += amount;
  }

  @Override
  public void withdraw(double amount) throws InsufficientFundsException {
    if (isClosed()) {
      throw new IllegalStateException("Cannot withdraw from a closed account");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive");
    }
    if (balance < amount) {
      throw new InsufficientFundsException("Account does not have enough funds for withdrawal");
    }
    balance -= amount;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void closeAccount() {
    if (balance > 0) {
      throw new IllegalStateException("Cannot close account with a positive balance");
    }
    isActive = false;
  }

  @Override
  public boolean isClosed() {
    return !isActive;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SavingsAccount other = (SavingsAccount) obj;
    return accountNumber.equals(other.accountNumber)
        && Double.compare(other.balance, balance) == 0
        && isActive == other.isActive
        && owners.equals(other.owners);
  }

  @Override
  public int hashCode() {
    int result = accountNumber.hashCode();
    result = 31 * result + Double.hashCode(balance);
    result = 31 * result + Boolean.hashCode(isActive);
    result = 31 * result + owners.hashCode();
    return result;
  }
}
