package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

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
    /**
     * Gets the account number.
     *
     * @return The account number.
     */

  public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient funds");
    }
    balance -= amount;
  }

  /**
   * Deposits funds into the account.
   *
   * @param amount The amount to deposit.
   */
  public void deposit(double amount) throws IllegalStateException {
    if (isClosed()) {
          throw new IllegalStateException("Cannot deposit to a closed account");
        }
        if (amount <= 0) {
          throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
      }
      protected abstract boolean isClosed();
}
