package com.codedifferently.lesson17.bank;

/** Represents a money order. */
public class MoneyOrder {

  private final String orderNumber;
  private final double amount;
  private final BankAccount sourceAccount;
  private boolean isRedeemed = false;

  /**
   * Creates a new money order and immediately withdraws funds.
   *
   * @param orderNumber The money order number.
   * @param amount The amount of the money order.
   * @param sourceAccount The account the money order is drawn from.
   */
  public MoneyOrder(String orderNumber, double amount, BankAccount sourceAccount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Money order amount must be positive");
    }
    this.orderNumber = orderNumber;
    this.amount = amount;
    this.sourceAccount = sourceAccount;

    // Immediately withdraw funds
    sourceAccount.withdraw(amount);
  }

  /** Checks if the money order has already been redeemed. */
  public boolean isRedeemed() {
    return isRedeemed;
  }

  /**
   * Redeems the money order to another account.
   *
   * @param toAccount The account receiving the funds.
   */
  public void redeem(BankAccount toAccount) {
    if (isRedeemed) {
      throw new IllegalStateException("Money order already redeemed");
    }
    toAccount.deposit(amount);
    isRedeemed = true;
  }

  @Override
  public int hashCode() {
    return orderNumber.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MoneyOrder other) {
      return orderNumber.equals(other.orderNumber);
    }
    return false;
  }

  @Override
  public String toString() {
    return "MoneyOrder{"
        + "orderNumber='"
        + orderNumber
        + '\''
        + ", amount="
        + amount
        + ", sourceAccount="
        + sourceAccount.getAccountNumber()
        + ", redeemed="
        + isRedeemed
        + '}';
  }
}
