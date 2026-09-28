package org.example;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.reflect.AccessFlag;
import java.nio.file.Path;
import java.util.List;

public class ClassFileParser {

    public ClassInfo parse(Path path) throws IOException {
        ClassModel cm = ClassFile.of().parse(path);

        List<String> methods = cm.methods().stream()
                .filter(m -> !m.flags().has(AccessFlag.SYNTHETIC))
                .map(m -> m.methodName().stringValue())
                .filter(n -> !n.equals("<init>") && !n.equals("<clinit>"))
                .toList();

        int fields = (int) cm.fields().stream()
                .filter(f -> !f.flags().has(AccessFlag.SYNTHETIC))
                .count();

        return new ClassInfo(cm.thisClass().asInternalName(), methods, fields);
    }
}
