package com.smalaca.domain;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String name;
    private final List<Commit> commits = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void merge(PullRequest pullRequest) {
        if (pullRequest.isPossibleToMergeTo(this)) {
            commits.addAll(pullRequest.getCommits());
        } else {
            throw new MergeException(this, pullRequest);
        }
    }

    public List<Commit> getCommits() {
        return commits;
    }
}
