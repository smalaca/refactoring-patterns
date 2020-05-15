package com.smalaca.codestructure;

public class InterfaceFile extends CodeFile {

    public InterfaceFile(String name, PackageName packageName) {
        super(name, packageName);
    }

    public int linesOfCode() {
        return getMethods().size() + 1;
    }
}
