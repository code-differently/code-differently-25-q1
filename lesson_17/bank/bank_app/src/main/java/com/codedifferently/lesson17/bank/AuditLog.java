package com.codedifferently.lesson17.bank;


import java.util.ArrayList;

public class AuditLog {
    private List<String> logEntries = new ArrayList<>(); 

    public void log (String message) {
        logEntries.add(message);
        System.out.println(message);

    }

    public List<String> getEntries() {
        return logEntries;
    }

    public void clear() {
        logEntries.clear();
    }
}
