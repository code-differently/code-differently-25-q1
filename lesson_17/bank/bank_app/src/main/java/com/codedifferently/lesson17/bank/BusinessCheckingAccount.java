package com.codedifferently.lesson17.bank;

import java.util.Set;

/** Represents a business checking account */
public class BusinessCheckingAccount extends CheckingAccount {

  /**
   * Creates a new business checking account
   *
   * @param accountNumber The accounnt number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  /**
   * Checks if at least one owner is a business.
   *
   * @param owners The owers of the account.
   * @throws IllegalArgumentEception If no business owner is found.
   */
  private void validateBusinessOwner(Set<Customer> owners) {
    boolean hasBusinessOwner = owners.stream().anyMatch(Customer::isBusiness);
    if (!hasBusinessOwner) {
      throw new IllegalArgumentException(
          "Business Checking Account must have at least one business owner");
    }
  }

  @Override
  public String toString() {
    return "BusinessCheckingAccount{"
        + "accountNumber='"
        + getAccountNumber()
        + '\''
        + ", balance="
        + getBalance()
        + ", isActive="
        + isActive()
        + '}';
  }
}
