package com.smalaca.domain;

import java.util.ArrayList;
import java.util.List;

public class CodeBaseDelta {
    private final List<CodeChange> changes = new ArrayList<>();

    public void add(CodeChange change) {
        changes.add(change);
    }

    void change(CodeBaseDelta codeBaseDelta) {
        changes.clear();
        changes.addAll(codeBaseDelta.changes);
    }
}
