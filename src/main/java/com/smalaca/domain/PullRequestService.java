package com.smalaca.domain;

public class PullRequestService {

    public void merge(Branch branch, PullRequest pullRequest) {
        branch.merge(pullRequest);
    }
}
