package com.smalaca.codestructure;

import com.smalaca.domain.ClassMethod;

import java.util.ArrayList;
import java.util.List;

abstract class CodeFile {
    private final String name;
    private final PackageName packageName;
    private final List<ClassMethod> methods = new ArrayList<>();

    protected CodeFile(String name, PackageName packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    public void addMethod(ClassMethod method) {
        methods.add(method);
    }

    protected List<ClassMethod> getMethods() {
        return methods;
    }
}
