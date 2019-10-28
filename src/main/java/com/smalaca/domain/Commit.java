package com.smalaca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commit {
    private final LocalDate creationDate;
    private final Author author;
    private final CodeBaseDelta codeBaseDelta;
    private final String[] message;
    private final List<Branch> branches = new ArrayList<>();

    public Commit(LocalDate creationDate, Author author, CodeBaseDelta codeBaseDelta, String[] message) {
        this.creationDate = creationDate;
        this.author = author;
        this.codeBaseDelta = codeBaseDelta;
        this.message = message;
    }

    public long creationEpochDay() {
        return creationDate.toEpochDay();
    }

    public Author getAuthor() {
        return author;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public String message() {
        return message[0] + " - " + message[1];
    }
}
