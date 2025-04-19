package com.codedifferently.lesson17.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {

  private final List<String> entries = new ArrayList<>();

  public void record(String message) {
    entries.add(LocalDateTime.now() + " - " + message);
  }

  public List<String> getEntries() {
    return entries;
  }

  public void printLog() {
    entries.forEach(System.out::println);
  }
}
