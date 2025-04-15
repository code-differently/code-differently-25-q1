package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

import main.java.com.codedifferently.lesson17.bank.AuditLog;
import main.java.com.codedifferently.lesson17.bank.BankAccount;
import main.java.com.codedifferently.lesson17.bank.MoneyOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a bank ATM. */
public class BankAtm {

  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, BankAccount> accountByNumber = new HashMap<>();
  private final AuditLog auditLog = new AuditLog();

  /**
   * Adds a checking account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(BankAccount account) {
    accountByNumber.put(account.getAccountNumber(), account);
    account.getOwners().forEach(owner -> customerById.put(owner.getId(), owner));
  }

  /**
   * Finds all accounts owned by a customer.
   *
   * @param customerId The ID of the customer.
   * @return The unique set of accounts owned by the customer.
   */
  public Set<BankAccount> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts()
        : Set.of();
  }

  /**
   * Deposits funds into an account.
   *
   * @param accountNumber The account number.
   * @param amount The amount to deposit.
   */
  public void depositFunds(String accountNumber, double amount) {
    BankAccount account = getAccountOrThrow(accountNumber);
    account.deposit(amount);
    auditLog.record("Deposited $" + amount + " to account " + accountNumber);
  }

  /**
   * Deposits funds into an account using a check.
   *
   * @param accountNumber The account number.
   * @param check The check to deposit.
   */
  public void depositFunds(String accountNumber, Check check) {
    BankAccount account = getAccountOrThrow(accountNumber);
    check.depositFunds(account);
    auditLog.record("Deposited check of $" + check.getAmount() + " into account " + accountNumber);
  }

  /**
   * Withdraws funds from an account.
   *
   * @param accountNumber
   * @param amount
   */
  public void withdrawFunds(String accountNumber, double amount) {
    BankAccount account = getAccountOrThrow(accountNumber);
    account.withdraw(amount);
    auditLog.record("Withdrew $" + amount + " from account " + accountNumber);
  }
   /**
    * Handles a money order transaction.
    * @param moneyOrder The money order to process.
    */
  public void handleMoneyOrder(MoneyOrder moneyOrder) throws InsufficientFundsException {
    BankAccount account = getAccountOrThrow(moneyOrder.getSourceAccount().getAccountNumber());
    moneyOrder.process();
    auditLog.record("Processed money order of $" + moneyOrder.getAmount() + " from account " + account.getAccountNumber());
  }
  /**
   * Gets an account by its number or throws an exception if not found.
   *
   * @param accountNumber The account number.
   * @return The account.
   */
  private BankAccount getAccountOrThrow(String accountNumber) {
    BankAccount account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
  }
}
