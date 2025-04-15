package com.codedifferently.lesson17.bank;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuditLog {
  private static final Logger logger = LogManager.getLogger(AuditLog.class.getName());
  private final List<String> logEntries = new ArrayList<>();

  public void log(String message) {
    logger.info(message);
    logEntries.add(message);
  }

  public List<String> getLogEntries() {
    return logEntries;
  }

  public void clear() {
    logEntries.clear();
    logger.debug("Audit log cleared");
  }
}
