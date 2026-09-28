package org.example;

import java.util.List;

public interface ResultPrinter {
    void print(ClassInfo info, List<CheckResult> results);
}