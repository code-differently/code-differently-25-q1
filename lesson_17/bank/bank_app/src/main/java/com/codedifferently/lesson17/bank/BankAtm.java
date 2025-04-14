package com.codedifferently.lesson17.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.codedifferently.lesson17.bank.exceptions.AccountNotFoundException;

/** Represents a bank ATM. */
public class BankAtm {

  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, CheckingAccount> accountByNumber = new HashMap<>();
  private final Map<String, BusinessAccount> accountByType = new HashMap<>();

  /**
   * Adds a checking account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(CheckingAccount account) {
    if (account == null) {
      throw new IllegalArgumentException("Account cannot be null");
    }
    accountByNumber.put(account.getAccountNumber(), account);
    account
        .getOwners()
        .forEach(
            owner -> {
              customerById.put(owner.getId(), owner);
            });
  }

  /**
   * Finds all accounts owned by a customer.
   *
   * @param customerId The ID of the customer.
   * @return The unique set of accounts owned by the customer.
   */
  public Set<Account> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts().stream().collect(Collectors.toSet())
        : Set.of();
  }

  /**
   * Deposits funds into an account.
   *
   * @param accountNumber The account number.
   * @param amount The amount to deposit.
   */
  public void depositFunds(String accountNumber, double amount) {
    Account account = getAccountOrThrow(accountNumber);

    if (account instanceof CheckingAccount) {
        ((CheckingAccount) account).deposit(amount);
    } else if (account instanceof BusinessAccount) {
        ((BusinessAccount) account).deposit(amount);
    } else {
        throw new IllegalArgumentException("Unsupported account type");
    }

  /**
   * Deposits funds into an account using a check.
   *
   * @param accountNumber The account number.
   * @param check The check to deposit.
   */
  public void depositFunds(String accountNumber, Check check) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    check.depositFunds(account);
  }

  /**
   * Withdraws funds from an account.
   *
   * @param accountNumber
   * @param amount
   */
  public void withdrawFunds(String accountNumber, double amount) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    account.withdraw(amount);
  }

  /**
   * Gets an account by its number or throws an exception if not found.
   *
   * @param accountNumber The account number.
   * @return The account.
   */
  private CheckingAccount getAccountOrThrow(String accountNumber) {
    CheckingAccount account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
  }
}
