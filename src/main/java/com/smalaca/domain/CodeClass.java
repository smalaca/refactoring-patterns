package com.smalaca.domain;

import java.util.List;

public class CodeClass {
    private final List<ClassAttribute> attributes;
    private final List<ClassMethod> methods;
    private final CodeClassType type;
    private CodeClass parent;

    public CodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClassType type) {
        this.attributes = attributes;
        this.methods = methods;
        this.type = type;
    }

    public CodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClassType type, CodeClass parent) {
        this.attributes = attributes;
        this.methods = methods;
        this.type = type;
        this.parent = parent;
    }

    public int linesOfCode() {
        if (CodeClassType.INTERFACE.equals(type)) {
            return linesOfInterfaceCode();
        }

        if (CodeClassType.ENUM.equals(type)) {
            return linesOfEnumCode();
        }

        return linesOfClassCode();
    }

    private int linesOfClassCode() {
        if (parent != null) {
            int linesOfCode = parent.linesOfCode();
            int amountOfAttributes = attributes.size();
            int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

            return linesOfCode + amountOfAttributes + methodsLength;
        } else {
            int amountOfAttributes = attributes.size();
            int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

            return amountOfAttributes + methodsLength;
        }
    }

    private int linesOfEnumCode() {
        int amountOfAttributes = attributes.size();
        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }

    private int linesOfInterfaceCode() {
        return methods.size() + 1;
    }

    public boolean hasMoreLinesThan(int linesOfCode) {
        int difference = linesOfCode - linesOfCode();

        if (difference > 0) {
            return false;
        } else {
            return true;
        }
    }
}
