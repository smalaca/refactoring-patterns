package com.smalaca.domain;

import java.util.List;

public abstract class CodeClass {
    protected final List<ClassAttribute> attributes;
    protected final List<ClassMethod> methods;

    protected CodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        this.attributes = attributes;
        this.methods = methods;
    }

    public abstract int linesOfCode();


    protected int linesOfCodeForClassWithoutParent() {
        int amountOfAttributes = attributes.size();
        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }

    public boolean hasMoreLinesThan(Integer linesOfCode) {
        linesOfCode -= linesOfCode();

        return linesOfCode <= 0;
    }
}
