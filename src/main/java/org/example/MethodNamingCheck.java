package org.example;


import java.util.List;

public class MethodNamingCheck implements Check {

    private static final String CAMEL_CASE = "^[a-z][a-zA-Z0-9]*$";

    @Override
    public CheckResult run(ClassInfo info) {
        List<String> bad = info.getMethodNames().stream()
                .filter(n -> !n.matches(CAMEL_CASE))
                .toList();

        if (bad.isEmpty()) {
            return new CheckResult("Method naming", true, "all methods are camelCase");
        }
        return new CheckResult("Method naming", false, "not camelCase: " + String.join(", ", bad));
    }
}