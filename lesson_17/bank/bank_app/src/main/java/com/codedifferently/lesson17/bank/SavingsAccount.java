package com.codedifferently.lesson17.bank;

import java.util.Set;

public class SavingsAccount extends CheckingAccount {

  public SavingsAccount(String accountNumber, Set<Customer> owners, double balance) {
    super(accountNumber, owners, balance);
  }

  @Override
  public int hashCode() {
    return getAccountNumber().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof SavingsAccount other) {
      return getAccountNumber().equals(other.getAccountNumber())
          && getOwners().equals(other.getOwners())
          && getBalance() == other.getBalance()
          && isClosed() == other.isClosed();
    }
    return false;
  }

  @Override
  public void withdraw(double amount) {
    throw new RuntimeException("Cannot withdraw from a savings account using a check");
  }

  @Override
  public String toString() {
    return "SavingsAccount"
        + "accountNumber='"
        + getAccountNumber()
        + '\''
        + ", owners="
        + getOwners()
        + ", balance="
        + getBalance()
        + ", isActive="
        + isClosed()
        + '}';
  }
}
