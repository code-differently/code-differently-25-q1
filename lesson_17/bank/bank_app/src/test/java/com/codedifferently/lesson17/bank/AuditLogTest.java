package com.codedifferently.lesson17.bank;

import org.junit.jupiter.api.Test;

public class AuditLogTest {
  @Test
  public void testLog() {
    AuditLog auditLog = new AuditLog();

    String message = "Test log message";
    auditLog.log(message);
  }

  @Test
  public void testGetLogEntries() {
    AuditLog auditLog = new AuditLog();

    String message1 = "Test log message 1";
    String message2 = "Test log message 2";
    auditLog.log(message1);
    auditLog.log(message2);

    assert auditLog.getLogEntries().size() == 2;
    assert auditLog.getLogEntries().get(0).equals(message1);
    assert auditLog.getLogEntries().get(1).equals(message2);
  }

  @Test
  public void testClear() {
    AuditLog auditLog = new AuditLog();

    String message = "Test log message";
    auditLog.log(message);
    auditLog.clear();

    assert auditLog.getLogEntries().isEmpty();
  }
}
