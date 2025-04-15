package com.codedifferently.lesson17.bank;

import java.util.ArrayList;
import java.util.List;

public class AuditLog {
    private List<String> logEntries;

    public AuditLog() {
        logEntries = new ArrayList<>();
    }

    public void logTransaction(BankAccount account, double amount, String transactionType) {
        String entry = String.format("%s transaction: %s | Amount: %.2f | Balance: %.2f",
            transactionType, account.getAccountNumber(), amount, account.getBalance());
        logEntries.add(entry);
        System.out.println(entry);  // You can remove this line if you prefer logging to a file or database
    }

    public List<String> getLogEntries() {
        return logEntries;
    }
}
