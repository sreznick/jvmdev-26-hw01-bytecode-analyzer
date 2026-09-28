package org.example;

import java.util.List;


public class ClassInfo {
    private final String name;
    private final List<String> methodNames;
    private final int fieldCount;

    public ClassInfo(String name, List<String> methodNames, int fieldCount) {
        this.name = name;
        this.methodNames = methodNames;
        this.fieldCount = fieldCount;
    }

    public String getName() {
        return name;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "name='" + name + '\'' +
                ", methodNames=" + methodNames +
                ", fieldCount=" + fieldCount +
                '}';
    }
}