package com.smalaca.codestructure;

import com.smalaca.domain.ClassAttribute;
import com.smalaca.domain.ClassMethod;

import java.util.ArrayList;
import java.util.List;

public class EnumFile extends CodeFile{
    private final List<ClassAttribute> attributes = new ArrayList<>();

    public EnumFile(String name, PackageName packageName) {
        super(name, packageName);
    }

    public void addAttribute(ClassAttribute attribute) {
        attributes.add(attribute);
    }

    public int linesOfCode() {
        int amountOfAttributes = attributes.size();
        int methodsLength = getMethods().stream().mapToInt(ClassMethod::bodySize).sum();

        return amountOfAttributes + methodsLength;
    }
}
