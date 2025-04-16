package com.codedifferently.lesson17.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {
  private final List<String> logEntries = new ArrayList<>();

  public void logTransaction(BankAccount account, double amount, String transactionType) {
    String entry =
        String.format(
            "%s transaction: %s | Amount: %.2f | Balance: %.2f",
            transactionType, account.getAccountNumber(), amount, account.getBalance());
    logEntries.add(entry);
    System.out.println(
        entry); // You can remove this line if you prefer logging to a file or database
  }

  public List<String> getLogEntries() {
    return logEntries;
  }

  public void record(String message) {
    String timestampedEntry = LocalDateTime.now() + " | " + message;
    logEntries.add(timestampedEntry);
    System.out.println(timestampedEntry); // Optional: For real-time feedback
  }

  public void printLog() {
    System.out.println("Audit Log:");
    for (String entry : logEntries) {
      System.out.println(entry);
    }
  }

  /**
   * Records an audit log message.
   *
   * @param message The message to record.
   */
  // Removed duplicate method definition for record(String message)
}
