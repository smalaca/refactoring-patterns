package com.smalaca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commit {
    private final String hashCode;
    private final LocalDate creationDate;
    private final Author author;
    private final CodeBaseDelta codeBaseDelta;
    private final List<Branch> branches = new ArrayList<>();
    private final Message message;

    public Commit(String hashCode, LocalDate creationDate, Author author, CodeBaseDelta codeBaseDelta, Message message) {
        this.hashCode = hashCode;
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
        return message.value();
    }

    boolean hasSameHashCodeAs(CommitAmend amend) {
        return hashCode.equals(amend.getHashCode());
    }

    CodeBaseDelta getCodeBaseDelta() {
        return codeBaseDelta;
    }

    public String getAuthorLogin() {
        return author.getLogin();
    }
}
