package org.example;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java Main <path/to/File.class>");
            System.exit(2);
        }
        List<Check> checks = List.of(
                new MethodNamingCheck(),
                new FieldCountCheck(10));
        ResultPrinter printer = new ConsolePrinter();
        ClassInfo info = new ClassFileParser().parse(Path.of(args[0]));

        List<CheckResult> results = checks.stream().map(c -> c.run(info)).toList();
        printer.print(info, results);

        boolean allPassed = results.stream().allMatch(CheckResult::isPassed);
        System.exit(allPassed ? 0 : 1);
    }
}