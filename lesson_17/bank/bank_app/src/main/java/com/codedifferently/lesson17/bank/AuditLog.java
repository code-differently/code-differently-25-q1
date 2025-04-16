package com.codedifferently.lesson17.bank;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code AuditLog} class is responsible for logging important events in the banking system. It
 * uses the Log4j logging framework to log messages at different levels.
 */
public class AuditLog {

  private static final Logger logger = LogManager.getLogger(AuditLog.class.getName());
  private final List<String> logEntries = new ArrayList<>();

  /**
   * Logs a message at the INFO level and adds it to the internal list of log entries.
   *
   * @param message
   */
  public void log(String message) {
    logger.info(message);
    logEntries.add(message);
  }

  /**
   * Logs an error message at the ERROR level and adds it to the internal list of log entries.
   *
   * @param message
   */
  public void logError(String message) {
    logger.error(message);
    logEntries.add(message);
  }

  /**
   * Returns the list of log entries.
   *
   * @return A list of log entries
   */
  public List<String> getLogEntries() {
    return logEntries;
  }

  public void clear() {
    logEntries.clear();
    logger.debug("Audit log cleared");
  }
}
