package com.smalaca.domain;

import java.time.LocalDate;

public class CodeBase {
    private final LocalDate creationDate;

    public CodeBase(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long latestChangeEpochDay() {
        return creationDate.toEpochDay();
    }
}
