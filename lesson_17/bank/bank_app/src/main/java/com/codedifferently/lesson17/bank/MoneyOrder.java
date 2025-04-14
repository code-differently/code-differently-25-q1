package main.java.com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.MoneyOrderVoidedException;

/** Represents a moneyorder. */
public class MoneyOrder {

  private final String moneyOrderNumber;
  private final double amount;
  private final CheckingAccount account;
  private boolean isVoided = false;

  /**
   * Creates a new moneyorder.
   *
   * @param moneyOrderNumber The moneyorder number.
   * @param amount The amount of the moneyorder.
   * @param account The account the moneyorder is drawn on.
   */
  public MoneyOrder(String moneyOrderNumber, double amount, CheckingAccount account) {
    if (amount < 0) {
      throw new IllegalArgumentException("MoneyOrder amount must be positive");
    }
    account.withdraw(amount);
    this.moneyOrderNumber = moneyOrderNumber;
    this.amount = amount;
    this.account = account;
  }

  /**
   * Gets the moneyorder number.
   *
   * @return The moneyorder number
   */
  public String getMoneyOrderNumber() {
    return moneyOrderNumber;
  }

  /**
   * Gets the amount given for the moneyorder.
   *
   * @return The amount.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Gets the account from the moneyordering account.
   *
   * @return The account in this instance.
   */
  public CheckingAccount getAccount() {
    return account;
  }

  /**
   * Gets the voided status of the moneyorder.
   *
   * @return True if the moneyorder is voided, and false otherwise.
   */
  public boolean getIsVoided() {
    return isVoided;
  }

  /** Voids the moneyorder. */
  public void voidMoneyOrder() {
    isVoided = true;
  }

  /**
   * Deposits the moneyorder into an account.
   *
   * @param toAccount The account to deposit the moneyorder into.
   */
  public void depositFunds(CheckingAccount toAccount) {
    if (isVoided) {
      throw new MoneyOrderVoidedException("MoneyOrder is voided");
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
    return "MoneyOrder{"
        + "moneyOrderNumber='"
        + moneyOrderNumber
        + '\''
        + ", amount="
        + amount
        + ", account="
        + account.getAccountNumber()
        + '}';
  }
}