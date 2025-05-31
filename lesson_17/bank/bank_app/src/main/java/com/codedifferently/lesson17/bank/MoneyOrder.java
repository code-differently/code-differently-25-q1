package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.CheckVoidedException;
import com.codedifferently.lesson17.bank.exceptions.MoneyOrderVoidedException;

/** Represents a check. */
public class MoneyOrder {

  private final String moneyOrderNumber;
  private final double amount;
  private final CheckingAccount account;
  private boolean isVoided = false;

  /**
   * Creates a new check.
   *
   * @param moneyOrderNumber The check number.
   * @param amount The amount of the check.
   * @param account The account the check is drawn on.
   */
  public MoneyOrder(String moneyOrderNumber, double amount, CheckingAccount account) {
    if (amount < 0) {
      throw new IllegalArgumentException("Money Order amount must be positive");
    }
    this.moneyOrderNumber = moneyOrderNumber;
    this.account = account;
    account.withdraw(amount);
    this.amount = amount ;
  }

  /**
   * Gets the voided status of the check.
   *
   * @return True if the check is voided, and false otherwise.
   */
  public boolean getIsVoided() {
    return isVoided;
  }

  /** Voids the MoneyOrder. */
  public void voidMoneyOrder() {
    isVoided = true;
  }

  /**
   * Deposits the money order into an account.
   *
   * @param toAccount The account to deposit the money order into.
   */
  public void depositFunds(CheckingAccount toAccount) {
    if (isVoided) {
      throw new MoneyOrderVoidedException("Money order is voided");
    }
    account.withdraw(amount);
    toAccount.deposit(amount);
    voidMoneyOrder();
  }

  @Override
  public int hashCode() {
    return moneyOrderNumber.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MoneyOrder other) {
      return moneyOrderNumber.equals(other.moneyOrderNumber);
    }
    return false;
  }

  @Override
  public String toString() {
    return "Money Order{"
        + "money Order Number='"
        + moneyOrderNumber
        + '\''
        + ", amount="
        + amount
        + ", account="
        + account.getAccountNumber()
        + '}';
  }
}
