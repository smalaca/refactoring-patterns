package com.smalaca.domain;

import java.time.LocalDate;

public class Commit {
    private final LocalDate creationDate;
    private final Author author;
    private final CodeBaseDelta codeBaseDelta;

    public Commit(LocalDate creationDate, Author author, CodeBaseDelta codeBaseDelta) {
        this.creationDate = creationDate;
        this.author = author;
        this.codeBaseDelta = codeBaseDelta;
    }

    public long creationEpochDay() {
        return creationDate.toEpochDay();
    }
}
