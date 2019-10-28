package com.smalaca.domain;

import java.util.List;

class InterfaceCodeClass extends CodeClass {
    protected InterfaceCodeClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        super(attributes, methods);
    }

    @Override
    public int linesOfCode() {
        return methods.size();
    }
}
