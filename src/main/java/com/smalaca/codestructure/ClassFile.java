package com.smalaca.codestructure;

import com.smalaca.domain.ClassAttribute;
import com.smalaca.domain.ClassMethod;
import com.smalaca.domain.CodeClass;

import java.util.ArrayList;
import java.util.List;

public class ClassFile extends CodeFile {
    private final List<ClassAttribute> attributes = new ArrayList<>();
    private CodeClass parent;

    public ClassFile(String name, PackageName packageName) {
        super(name, packageName);
    }

    public void addAttribute(ClassAttribute attribute) {
        attributes.add(attribute);
    }

    public int linesOfCode() {
        int linesOfCode = 0;
        if (parent != null) {
            linesOfCode += parent.linesOfCode();
        }

        int amountOfAttributes = attributes.size();
        int methodsLength = getMethods().stream().mapToInt(ClassMethod::bodySize).sum();

        return linesOfCode + amountOfAttributes + methodsLength;
    }
}
