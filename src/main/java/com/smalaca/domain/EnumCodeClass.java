package com.smalaca.domain;

import java.util.List;

class EnumCodeClass extends CodeClass {
    protected EnumCodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        super(attributes, methods);
    }

    @Override
    public int linesOfCode() {
//        int amountOfAttributes = attributes.size();
//        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return linesOfCodeForClassWithoutParent();
    }

}
