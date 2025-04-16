package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a bank ATM. */
public class BankAtm {

  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, CheckingAccount> accountByNumber = new HashMap<>();
  private final AuditLog auditLog;

  public BankAtm(AuditLog auditLog) {

    this.auditLog = auditLog;
  }

  /**
   * Adds a checking account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(CheckingAccount account) {
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
  public Set<CheckingAccount> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts()
        : Set.of();
  }

  /**
   * Deposits funds into the specified account. This method supports both cash (Double) and
   * MoneyOrder objects as deposit sources.
   *
   * @param accountNumber the account to deposit into
   * @param source the deposit source; must be a Double (cash) or MoneyOrder
   */
  public void depositFunds(String accountNumber, Object source) {
    // Retrieve the target account using the provided account number
    CheckingAccount targetAccount = (CheckingAccount) accountByNumber.get(accountNumber);

    // If the deposit source is a MoneyOrder, extract the amount and deposit it
    if (source instanceof MoneyOrder newMoneyOrder) {
      if (targetAccount != null) {
        double amount = newMoneyOrder.getAmount();
        targetAccount.deposit(amount);
        auditLog.record("Deposited $" + amount + " via MoneyOrder to account " + accountNumber);
      }
    }
    // If the deposit source is cash (Double), proceed with a standard deposit
    else if (source instanceof Double amount) {
      if (targetAccount != null) {
        targetAccount.deposit(amount);
        auditLog.record("Deposited $" + amount + " in cash to account " + accountNumber);
      }
    }
    // If the source type is unsupported, throw an exception
    else {
      throw new IllegalArgumentException("Unsupported deposit type");
    }
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
    auditLog.record("Deposited check" + check + "into account" + accountNumber);
  }

  public void printAuditLog() {
    auditLog.printLog();
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
    auditLog.record("Withdrew $" + amount + "from account" + accountNumber);
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
