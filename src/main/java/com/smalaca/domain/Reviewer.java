package com.smalaca.domain;

public class Reviewer {
    private static final String NOT_STARTED = "NS";
    private static final String COMMENTS = "C";
    private static final String REJECTED = "R";
    private static final String ACCEPTED = "A";

    private final String login;
    private String status = NOT_STARTED;

    public Reviewer(String login) {
        this.login = login;
    }

    public boolean isAccepted() {
        return ACCEPTED.equals(status);
    }

    public String getLogin() {
        return login;
    }
}
