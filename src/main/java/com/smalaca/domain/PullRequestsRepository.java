package com.smalaca.domain;

public class PullRequestsRepository {
    private final PullRequestRepository pullRequestRepository;

    public PullRequestsRepository(PullRequestRepository pullRequestRepository) {
        this.pullRequestRepository = pullRequestRepository;
    }

    public PullRequest findFix(String id) {
        return pullRequestRepository.find(id);
    }

    public PullRequest findChangeRequest(String id) {
        return pullRequestRepository.find(id);
    }

    public PullRequest findImprovement(String id) {
        return pullRequestRepository.find(id);
    }
}
