package com.smalaca.domain;

public class Build {
    private boolean isSuccessful;

    public boolean isFailed() {
        return !isSuccessful;
    }
}
