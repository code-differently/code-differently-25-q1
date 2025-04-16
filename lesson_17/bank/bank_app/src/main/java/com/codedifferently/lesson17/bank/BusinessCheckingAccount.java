package com.codedifferently.lesson17.bank;

import java.util.Set;

public final class BusinessCheckingAccount extends CheckingAccount {

  /**
   * Represents a business checking account.
   *
   * <p>It is a subclass of BankAccount and inherits its properties and methods.
   */
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
    if (!hasBusinessOwner(owners)) {
      throw new IllegalArgumentException(
          "A BusinessCheckingAccount must have at least one business owner.");
    }
  }

  /**
   * Checks if the owners of the account include at least one business customer.
   *
   * @param owners The owners of the account.
   * @return true if there is a business owner, false otherwise.
   */
  private boolean hasBusinessOwner(Set<Customer> owners) {
    return owners.stream().anyMatch(owner -> owner instanceof BusinessCustomer);
  }
}
