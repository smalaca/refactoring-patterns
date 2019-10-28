package com.smalaca.domain;

class CommitNotPresentException extends RuntimeException {
    private final String id;

    private CommitNotPresentException(String id, String message) {
        super(message);
        this.id = id;
    }

    static RuntimeException first(String id) {
        return new CommitNotPresentException(id, "No first commit found");
    }

    static RuntimeException latest(String id) {
        return new CommitNotPresentException(id, "No latest commit found");
    }
}
