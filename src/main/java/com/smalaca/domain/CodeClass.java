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
        switch(type){
            case ENUM:
                return linesOfCodeForEnum();
            case INTERFACE:
                return methods.size();
            default:
                if (parent != null) {
                    return linesOfCodeForClassWithParent();
                } else {
                    return linesOfCodeForClassWithoutParent();
                }
        }
    }

    private int linesOfCodeForClassWithoutParent() {
        int amountOfAttributes = attributes.size();
        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }

    private int linesOfCodeForClassWithParent() {
        return linesOfCodeForClassWithoutParent() + parent.linesOfCode();
    }

    private int linesOfCodeForEnum() {
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
