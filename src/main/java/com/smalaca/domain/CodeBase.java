package com.smalaca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CodeBase {
    private final LocalDate creationDate;
    private final List<Branch> branches = new ArrayList<>();

    public CodeBase(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long latestChangeEpochDay() {
        return creationDate.toEpochDay();
    }

    public List<Branch> getBranches() {
        return branches;
    }
}
