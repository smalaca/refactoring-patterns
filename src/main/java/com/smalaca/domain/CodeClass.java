package com.smalaca.domain;

import java.util.List;

public class CodeClass {
    private final List<ClassAttribute> attributes;
    private final List<ClassMethod> methods;

    public CodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        this.attributes = attributes;
        this.methods = methods;
    }

    public int linesOfCode() {
        int amountOfAttributes = attributes.size();
        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }

    public boolean hasMoreLinesThan(int linesOfCode) {
        linesOfCode -= linesOfCode();

        if (linesOfCode > 0) {
            return false;
        } else {
            return true;
        }
    }
}
