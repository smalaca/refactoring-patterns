package com.smalaca.domain;

import java.time.LocalDate;

public class CodeChange {
    private final Author author;
    private final ChangeScope scope;
    private final CodeBaseDelta codeBaseDelta;
    private final Justification justification;
    private final LocalDate date;

    public CodeChange(Author author, ChangeScope scope, CodeBaseDelta codeBaseDelta, Justification justification, LocalDate date) {
        this.author = author;
        this.scope = scope;
        this.codeBaseDelta = codeBaseDelta;
        this.justification = justification;
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public ChangeScope getScope() {
        return scope;
    }

    public CodeBaseDelta getCodeBaseDelta() {
        return codeBaseDelta;
    }

    public Justification getJustification() {
        return justification;
    }

    public LocalDate getDate() {
        return date;
    }
}
