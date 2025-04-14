package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/** Represents a savings account. */
public class SavingsAccount extends BankAccount {

  /**
   * Creates a new savings account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  /**
   * Withdraws funds from the account.
   *
   * @param amount
   * @throws InsufficientFundsException
   */
  public void withdraw(double amount) {
    throw new UnsupportedOperationException("Withdrawals are not allowed from savings accounts");
  }
}
