package com.codedifferently.lesson17.bank;

/** A specialized type of BankAccount representing a source of funds. */
public class SourceAccount extends BankAccount {

  /**
   * Constructs a SourceAccount with the given account number and initial balance.
   *
   * @param accountNumber The account number.
   * @param initialBalance The starting balance.
   */
  public SourceAccount(String accountNumber, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
