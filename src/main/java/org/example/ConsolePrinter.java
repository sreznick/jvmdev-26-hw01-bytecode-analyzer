package org.example;

import java.util.List;

public class ConsolePrinter implements ResultPrinter {

    @Override
    public void print(ClassInfo info, List<CheckResult> results) {
        System.out.println("Class: " + info.getName());
        for (CheckResult r : results) {
            System.out.printf("[%s] %s: %s%n", r.isPassed() ? "PASS" : "FAIL", r.getCheckName(), r.getMessage());
        }
    }
}
