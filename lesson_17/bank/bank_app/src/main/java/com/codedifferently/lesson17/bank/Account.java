package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/** Abstract base class for all bank accounts. */
@Getter
@Setter
public abstract class Account {
  private final Set<Customer> owners;
  private final String accountNumber;
  private double balance;
  private boolean isActive;

  /**
   * Creates a new account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initalBalance The inital balance of the account.
   */
  public Account(String accountNumber, Set<Customer> owners, double initalBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initalBalance;
    this.isActive = true;
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

  /**
   * Withdraws funds from the account.
   *
   * @param amount
   * @throws InsufficientFundsException
   */
  public void withdraw(double amount) throws InsufficientFundsException {
    if (isClosed()) {
      throw new IllegalStateException("Cannot withdraw from a closed account");
    }
    if (amount <= 0) {
      throw new IllegalStateException("Withdrawal amount must be positive");
    }
    if (balance < amount) {
      throw new InsufficientFundsException("Account does not have enough funds for withdrawal");
    }
    balance -= amount;
  }

  /** Closes the account. */
  public void closeAccount() throws IllegalStateException {
    if (balance > 0) {
      throw new IllegalStateException("Cannot close account with a positive balance");
    }
    isActive = false;
  }

  /**
   * Checks if the account is closed.
   *
   * @return True if the account is closed, otherwise false.
   */
  public boolean isClosed() {
    return !isActive;
  }

  @Override
  public int hashCode() {
    return accountNumber.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CheckingAccount other) {
      return accountNumber.equals(other.getAccountNumber());
    }
    return false;
  }
}
