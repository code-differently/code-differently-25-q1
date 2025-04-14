package com.codedifferently.lesson17.bank;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a new saving account.
 *
 * @param accountNumber The account number as log transaction key.
 * @param value The actual debit/credit transaction.
 * @param accountNumberByValueLog The audit log object.
 */
public class AuditLog {

  // Method to add a value to an existing ArrayList or create a new one if accountNumber doesn't
  // exist
  public void addToMap(
      HashMap<String, ArrayList<Double>> accountNumberByValueLog,
      String accountNumber,
      Double value) {
    accountNumberByValueLog.computeIfAbsent(accountNumber, k -> new ArrayList<>()).add(value);
  }
}