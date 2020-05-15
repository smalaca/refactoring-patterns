package com.smalaca.codestructure;

import com.smalaca.domain.ClassMethod;

import java.util.ArrayList;
import java.util.List;

public class InterfaceFile extends CodeFile {
    private final List<ClassMethod> methods = new ArrayList<>();

    public InterfaceFile(String name, PackageName packageName) {
        super(name, packageName);
    }

    public void addMethod(ClassMethod method) {
        methods.add(method);
    }


    public int linesOfCode() {
        return methods.size() + 1;
    }
}
