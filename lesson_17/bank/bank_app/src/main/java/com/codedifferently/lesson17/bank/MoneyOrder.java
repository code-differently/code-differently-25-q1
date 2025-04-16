package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

public class MoneyOrder {
  private final BankAccount sourceAccount;
  private final double amount;

  public MoneyOrder(BankAccount sourceAccount, double amount) {
    this.sourceAccount = sourceAccount;
    this.amount = amount;
  }

  public BankAccount getSourceAccount() {
    return sourceAccount;
  }

  public double getAmount() {
    return amount;
  }

  public void process() throws InsufficientFundsException {
    if (sourceAccount.getBalance() < amount) {
      throw new InsufficientFundsException("Insufficient funds for money order.");
    }
    sourceAccount.withdraw(amount);
  }
}
