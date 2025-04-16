package com.codedifferently.lesson17.bank;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents a saving account. */
public class SavingsAccount extends BankAccount {
  // private boolean isActive;
  private final boolean isCheckCreationAllowed;
  private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);

  /**
   * Creates a new saving account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public SavingsAccount(String accountNumber, Set<Customer> owners, double balance) {
    super(accountNumber, owners, balance);
    logger.info("Saving Account constructor accessed...");
    isCheckCreationAllowed = false;
  }

  public boolean isActive() {
    // Logic to determine if the account is active
    return true; // Replace with actual logic
  }

  @Override
  public String toString() {
    return "SavingsAccount{"
        + "accountNumber='"
        + getAccountNumber()
        + '\''
        + ", balance="
        + getBalance()
        + ", isActive="
        + isActive()
        + '}';
  }

  public boolean isCheckCreationAllowed() {
    return isCheckCreationAllowed;
  }
}
