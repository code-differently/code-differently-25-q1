package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuditLogTest {

  private AuditLog auditLog;
  private BankAccount account;

  @BeforeEach
  void setUp() {
    auditLog = new AuditLog();
    Customer customer = new Customer(UUID.randomUUID(), "Test User");
    account = new CheckingAccount("123456789", Set.of(customer), 100.0);
  }

  @Test
  void testLogTransaction_addsCorrectEntry() {
    auditLog.logTransaction(account, 50.0, "Deposit");

    List<String> entries = auditLog.getLogEntries();

    assertThat(entries).hasSize(1);
    assertThat(entries.get(0))
        .contains("Deposit transaction: 123456789")
        .contains("Amount: 50.00")
        .contains("Balance: 100.00");
  }

  @Test
  void testRecord_addsTimestampedEntry() {
    auditLog.record("Custom event happened.");

    List<String> entries = auditLog.getLogEntries();

    assertThat(entries).hasSize(1);
    assertThat(entries.get(0)).contains("Custom event happened.");
    assertThat(entries.get(0)).contains("|"); // timestamp separator
  }

  @Test
  void testMultipleEntries_loggedInOrder() {
    auditLog.logTransaction(account, 25.0, "Withdrawal");
    auditLog.record("Manual log entry.");
    auditLog.logTransaction(account, 10.0, "Deposit");

    List<String> entries = auditLog.getLogEntries();

    assertThat(entries).hasSize(3);
    assertThat(entries.get(0)).contains("Withdrawal");
    assertThat(entries.get(1)).contains("Manual log entry.");
    assertThat(entries.get(2)).contains("Deposit");
  }
}
