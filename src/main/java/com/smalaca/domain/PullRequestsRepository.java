package com.smalaca.domain;

public class PullRequestsRepository {
    private final PullRequestRepository pullRequestRepository;

    public PullRequestsRepository(PullRequestRepository pullRequestRepository) {
        this.pullRequestRepository = pullRequestRepository;
    }

    public Fix findFix(String id) {
        return (Fix) pullRequestRepository.find(id);
    }

    public ChangeRequest findChangeRequest(String id) {
        return (ChangeRequest) pullRequestRepository.find(id);
    }

    public Improvement findImprovement(String id) {
        return (Improvement) pullRequestRepository.find(id);
    }
}
