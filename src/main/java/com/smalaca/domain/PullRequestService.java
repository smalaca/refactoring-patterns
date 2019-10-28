package com.smalaca.domain;

public class PullRequestService {

    public int merge(Branch branch, PullRequest pullRequest) {
        try {
            branch.merge(pullRequest);
            return 1;
        } catch (MergeException exception) {
            return -1;
        }
    }
}
