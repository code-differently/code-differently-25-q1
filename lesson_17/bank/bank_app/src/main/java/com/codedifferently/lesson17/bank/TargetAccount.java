package com.codedifferently.lesson17.bank;

/** A specialized type of BankAccount representing a target (destination) for funds. */
public class TargetAccount extends BankAccount {

  /**
   * Constructs a TargetAccount with the given account number and initial balance.
   *
   * @param accountNumber The account number.
   * @param initialBalance The starting balance.
   */
  public TargetAccount(String accountNumber, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
