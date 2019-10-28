package com.smalaca.domain;

import java.util.List;

class ClazzCodeClass extends CodeClass {
    private CodeClass parent;

    ClazzCodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        super(attributes, methods);
    }

     ClazzCodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClass parent) {
        this(attributes, methods);
        this.parent = parent;
    }

    @Override
    public int linesOfCode() {
        if (parent != null) {
            return linesOfCodeForClassWithParent();
        } else {
            return linesOfCodeForClassWithoutParent();
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
}
