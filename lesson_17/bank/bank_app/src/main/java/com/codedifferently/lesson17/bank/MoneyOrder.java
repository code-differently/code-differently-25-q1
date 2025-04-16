package com.codedifferently.lesson17.bank;

import java.util.UUID;

public class MoneyOrder extends Check {

  public MoneyOrder(CheckingAccount sourceAccount, double amount) {
    super("MO-" + UUID.randomUUID(), amount, sourceAccount);

    sourceAccount.withdraw(amount);

    AuditLog.getInstance().log("MONEY ORDER ISSUED", sourceAccount.getAccountNumber(), amount);
  }

  @Override
  public void depositFunds(CheckingAccount toAccount) {
    if (getIsVoided()) {
      throw new RuntimeException("This money order has already been deposited or voided.");
    }

    toAccount.deposit(getAmount());
    voidCheck();

    AuditLog.getInstance().log("MONEY ORDER DEPOSIT", toAccount.getAccountNumber(), getAmount());
  }
}
