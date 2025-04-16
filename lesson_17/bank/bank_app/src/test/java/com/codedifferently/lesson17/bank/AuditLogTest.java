package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuditLogTest {

  private BankAtm bankAtm;
  private CheckingAccount sourceAccount;
  private CheckingAccount targetAccount;

  @BeforeEach
  void setUp() {
    AuditLog.getInstance().clear();

    bankAtm = new BankAtm();

    Customer alice = new Customer(UUID.randomUUID(), "Alice");
    Customer bob = new Customer(UUID.randomUUID(), "Bob");

    Set<Customer> owners1 = Set.of(alice);
    Set<Customer> owners2 = Set.of(bob);

    sourceAccount = new CheckingAccount("SRC123", owners1, 1000.0);
    targetAccount = new CheckingAccount("TRG456", owners2, 500.0);

    bankAtm.addAccount(sourceAccount);
    bankAtm.addAccount(targetAccount);
  }

  @Test
  void testAuditLogRecordsStandardDeposit() {
    bankAtm.depositFunds(targetAccount.getAccountNumber(), 500.0);

    List<String> entries = AuditLog.getInstance().getEntries();
    assertTrue(entries.stream().anyMatch(e -> e.contains("DEPOSIT") && e.contains("TRG456")));
  }

  @Test
  void testAuditLogRecordsStandardWithdrawal() {
    bankAtm.depositFunds(targetAccount.getAccountNumber(), 200.0);
    bankAtm.withdrawFunds(targetAccount.getAccountNumber(), 100.0);

    List<String> entries = AuditLog.getInstance().getEntries();
    assertTrue(entries.stream().anyMatch(e -> e.contains("WITHDRAWAL") && e.contains("TRG456")));
  }

  @Test
  void testAuditLogRecordsCheckDeposit() {
    Check check = new Check("CHK123", 100.0, sourceAccount);
    bankAtm.depositFunds(targetAccount.getAccountNumber(), check);

    List<String> entries = AuditLog.getInstance().getEntries();
    assertTrue(entries.stream().anyMatch(e -> e.contains("CHECK DEPOSIT")));
  }
}
