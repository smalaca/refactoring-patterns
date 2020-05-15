package com.smalaca.codestructure;

abstract class CodeFile {
    private final String name;
    private final PackageName packageName;

    protected CodeFile(String name, PackageName packageName) {
        this.name = name;
        this.packageName = packageName;
    }
}
