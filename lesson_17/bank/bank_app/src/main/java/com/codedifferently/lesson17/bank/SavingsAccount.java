package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

/**
 * The {@code SavingsAccount} class represents a savings account in a banking system. It extends the
 * {@code CheckingAccount} class and provides additional functionality specific to savings accounts.
 */
public class SavingsAccount extends CheckingAccount {

  /**
   * Constructs a new SavingsAccount with the specified account number, owners, and balance.
   *
   * @param accountNumber
   * @param owners
   * @param balance
   */
  public SavingsAccount(String accountNumber, Set<Customer> owners, double balance) {
    super(accountNumber, owners, balance);
  }

  /**
   * Gets the HashCode of the account number.
   *
   * @return The hash code of the account number.
   */
  @Override
  public int hashCode() {
    return getAccountNumber().hashCode();
  }

  /**
   * Checks if this SavingsAccount is equal to another object.
   *
   * @param obj The object to compare with.
   * @return true if the objects are equal, false otherwise.
   */
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

  /**
   * Will throw and exception if the user attempt to make a withdrawl while under the instance of
   * SavingsAccount.
   * 
   * And the makes a second withdrawl that will check if there 
   * is a check and throw an error if one comes in.
   *
   * @param amount The amount to deposit.
   */
  @Override
  public void withdraw(double amount) throws InsufficientFundsException {
    throw new IllegalStateException("you cannot write a check from the savings account");
  }

  public void withdraw(double amount, Check check) {
    if (check != null) {
      throw new IllegalStateException("Cannot withdraw from a savings account using a check");
    }
    withdraw(amount); // Call the original withdraw method
  }

  /**
   * Returns a string representation of the SavingsAccount.
   *
   * @return A string representation of the SavingsAccount.
   */
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
