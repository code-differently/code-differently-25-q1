package com.codedifferently.lesson17.bank;

public class AuditLog {
    private final List<String> entries = new ArrayList<>();

    public void record(String message) {
        entries.add(LocalDateTime.now() + " - " + message);
    }

    public List<String> getEntries() {
        return entries;
    }
}


