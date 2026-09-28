package org.example;

public class CheckResult {
    private final String checkName;
    private final boolean passed;
    private final String message;

    public CheckResult(String checkName, boolean passed, String message) {
        this.checkName = checkName;
        this.passed = passed;
        this.message = message;
    }

    public String getCheckName() {
        return checkName;
    }

    public boolean isPassed() {
        return passed;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "checkName='" + checkName + '\'' +
                ", passed=" + passed +
                ", message='" + message + '\'' +
                '}';
    }
}
