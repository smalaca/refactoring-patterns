package com.smalaca.application;

import com.smalaca.domain.*;

import java.util.ArrayList;

public class ClassesClient {

    private final CodeClassFactory codeClassFactory;

    public ClassesClient(CodeClassFactory codeClassFactory) {
        this.codeClassFactory = codeClassFactory;
    }

    public void foo() {
        CodeClass codeClass = codeClassFactory.create(new ArrayList<ClassAttribute>(), new ArrayList<ClassMethod>(), CodeClassType.ENUM);

        User user1 = User.admin("login");
        User user2 = User.readOnly("login");
        User user3 = User.developer("login");
    }

    public void bar() {
        CodeClass codeClass = codeClassFactory.create(new ArrayList<>(), new ArrayList<>(), CodeClassType.ENUM);
    }

    public void baz() {
        CodeClass parent = codeClassFactory.create(new ArrayList<>(), new ArrayList<>(), CodeClassType.ENUM);
        CodeClass codeClass = codeClassFactory.create(new ArrayList<>(), new ArrayList<>(), CodeClassType.ENUM, parent);
    }
}
