package com.smalaca.domain;

import java.util.Collections;

class EmptyCodeClass extends CodeClass {
    public EmptyCodeClass() {
        super(Collections.emptyList(), Collections.emptyList(), CodeClassType.INTERFACE);
    }

    @Override
    public int linesOfCode() {
        return 0;
    }

    @Override
    public boolean hasMoreLinesThan(int linesOfCode) {
        return false;
    }
}
