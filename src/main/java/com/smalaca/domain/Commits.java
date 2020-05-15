package com.smalaca.domain;

import java.util.List;

class Commits {
    private final List<Commit> commits;

    Commits(List<Commit> commits) {
        this.commits = commits;
    }

    void add(Commit commit) {
        commits.add(commit);
    }

    List<Commit> getAll() {
        return commits;
    }
}
