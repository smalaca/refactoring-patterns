package com.smalaca.services;

import com.smalaca.domain.*;

public class PullRequestService {
    private final PullRequestsRepository pullRequestsRepository;

    PullRequestService(PullRequestsRepository pullRequestsRepository) {
        this.pullRequestsRepository = pullRequestsRepository;
    }

    public int modifyFix(String id, CommitAmend amend) {
        PullRequest pullRequest = pullRequestsRepository.findFix(id);
        pullRequest.amend(amend);

        return 1;
    }

    public int modifyImprovement(String id, CommitAmend amend) {
        PullRequest pullRequest = pullRequestsRepository.findImprovement(id);
        pullRequest.amend(amend);

        return 1;
    }

    public int modifyChangeRequest(String id, CommitAmend amend) {
        PullRequest pullRequest = pullRequestsRepository.findChangeRequest(id);
        pullRequest.amend(amend);

        return 1;
    }
}
