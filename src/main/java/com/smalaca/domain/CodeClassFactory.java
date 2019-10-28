package com.smalaca.domain;

import java.util.List;

public class CodeClassFactory {
    public CodeClass create(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClassType type) {
        CodeClass codeClass = null;

        if(type == CodeClassType.ENUM) {
            codeClass = new EnumCodeClass(attributes, methods);
        }

        if(type == CodeClassType.INTERFACE) {
            return new InterfaceCodeClass(attributes, methods);
        }

        if(type == CodeClassType.CLAZZ) {
            return new ClazzCodeClass(attributes, methods);
        }

        return codeClass;
    }

    public CodeClass create(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClassType type, CodeClass parent) {
        CodeClass codeClass = null;

        if(type == CodeClassType.CLAZZ) {
            return new ClazzCodeClass(attributes, methods, parent);
        }

        return codeClass;
    }
}
