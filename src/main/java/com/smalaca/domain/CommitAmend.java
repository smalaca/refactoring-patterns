package com.smalaca.domain;

public class CommitAmend {
    private final String hashCode;
    private final CodeBaseDelta codeBaseDelta;

    public CommitAmend(String hashCode, CodeBaseDelta codeBaseDelta) {
        this.hashCode = hashCode;
        this.codeBaseDelta = codeBaseDelta;
    }

    String getHashCode() {
        return hashCode;
    }

    CodeBaseDelta getCodeBaseDelta() {
        return codeBaseDelta;
    }
}
