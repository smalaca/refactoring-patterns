package com.smalaca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commit {
    private final String hashCode;
    private final LocalDate creationDate;
    private final Author author;
    private final CodeBaseDelta codeBaseDelta;
    private final String[] messageArray;
    private final List<Branch> branches = new ArrayList<>();

    public Commit(String hashCode, LocalDate creationDate, Author author, CodeBaseDelta codeBaseDelta, String[] message) {
        this.hashCode = hashCode;
        this.creationDate = creationDate;
        this.author = author;
        this.codeBaseDelta = codeBaseDelta;
        this.messageArray = message;
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
        return messageArray[0] + " - " + messageArray[1];
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
