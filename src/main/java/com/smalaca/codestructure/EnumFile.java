package com.smalaca.codestructure;

import com.smalaca.domain.ClassAttribute;
import com.smalaca.domain.ClassMethod;

import java.util.ArrayList;
import java.util.List;

public class EnumFile {
    private final String name;
    private final PackageName packageName;
    private final List<ClassAttribute> attributes = new ArrayList<>();
    private final List<ClassMethod> methods = new ArrayList<>();

    public EnumFile(String name, PackageName packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    public void addAttribute(ClassAttribute attribute) {
        attributes.add(attribute);
    }

    public void addMethod(ClassMethod method) {
        methods.add(method);
    }

    public int linesOfCode() {
        int amountOfAttributes = attributes.size();
        int methodsLength = methods.stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }
}
