package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InvalidBusinessAccountException;
import java.util.Set;

/**
 * Creates a business account.
 *
 * @param accountNumber The account number.
 * @param owners The owners of the account.
 * @param initialBalance The initial balance of the account.
 */
public class BusinessCheckingAccount extends CheckingAccount {
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);

    boolean hasBusinessOwner = owners.stream().anyMatch(customer -> customer.isBusiness());
    if (!hasBusinessOwner) {
      throw new InvalidBusinessAccountException("At least one owner must be a business.");
    }
  }
}
