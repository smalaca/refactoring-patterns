package com.smalaca.domain;

public interface PullRequestRepository {
    PullRequest find(String pullRequestId);
}
