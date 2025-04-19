package com.codedifferently.lesson17.bank;

public class MoneyOrder {
  private final double amount;
  private final String sourceAccountNumber;

  public MoneyOrder(CheckingAccount sourceAccount, double amount) {
    this.amount = amount;
    this.sourceAccountNumber = sourceAccount.getAccountNumber();
    sourceAccount.withdraw(amount); // Withdraw immediately
  }

  public double getAmount() {
    return amount;
  }

  public String getSourceAccountNumber() {
    return sourceAccountNumber;
  }

  public void depositTo(CheckingAccount destinationAccount) {
    destinationAccount.deposit(amount);
  }
}
