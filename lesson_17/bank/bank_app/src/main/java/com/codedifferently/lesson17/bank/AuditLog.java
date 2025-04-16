package com.codedifferently.lesson17.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditLog {

  private static final AuditLog INSTANCE = new AuditLog();

  private final List<String> entries;

  private AuditLog() {
    this.entries = new ArrayList<>();
  }

  public static AuditLog getInstance() {
    return INSTANCE;
  }

  public void log(String type, String accountNumber, double amount) {
    String entry = String.format("%s - Account: %s, Amount: %.2f", type, accountNumber, amount);
    entries.add(entry);
  }

  public List<String> getEntries() {
    return Collections.unmodifiableList(entries);
  }

  public void clear() {
    entries.clear();
  }
}
