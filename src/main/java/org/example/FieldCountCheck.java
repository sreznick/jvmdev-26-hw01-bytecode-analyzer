package org.example;

public class FieldCountCheck implements Check {

    private final int max;

    public FieldCountCheck(int max) {
        this.max = max;
    }

    @Override
    public CheckResult run(ClassInfo info) {
        boolean ok = info.getFieldCount() <= max;
        return new CheckResult("Field count", ok,
                info.getFieldCount() + " fields (max " + max + ")");
    }
}
