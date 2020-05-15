package com.smalaca.services;

import com.smalaca.domain.*;

import java.util.Collections;
import java.util.List;

class CodeClassService {
    public final CodeClassRepository repository;

    CodeClassService(CodeClassRepository repository) {
        this.repository = repository;
    }

    public CodeClass createInterface(List<ClassMethod> methods) {
        CodeClass codeClass = new CodeClass(Collections.emptyList(), methods, CodeClassType.INTERFACE);

        repository.save(codeClass);

        return codeClass;
    }

    public CodeClass createEnum(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        CodeClass codeClass = new CodeClass(attributes, methods, CodeClassType.ENUM);

        repository.save(codeClass);

        return codeClass;
    }

    public CodeClass createClass(List<ClassAttribute> attributes, List<ClassMethod> methods) {
        CodeClass codeClass = new CodeClass(attributes, methods, CodeClassType.CLASS);

        repository.save(codeClass);

        return codeClass;
    }

    public CodeClass createClassWithParent(List<ClassAttribute> attributes, List<ClassMethod> methods, CodeClass parent) {
        CodeClass codeClass = new CodeClass(attributes, methods, CodeClassType.CLASS, parent);

        repository.save(codeClass);

        return codeClass;
    }
}
