package com.kodilla.patterns.singleton;

import java.util.ArrayList;
import java.util.List;

public enum Logger {

    INSTANCE;

    private String lastLog = "";
    private final List<String> logHistory = new ArrayList<>();

    public void log (String log) {
        lastLog = log;
        logHistory.add(lastLog);
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }

    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }
}
