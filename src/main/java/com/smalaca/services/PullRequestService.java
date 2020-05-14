package com.smalaca.services;

import com.smalaca.domain.*;

public class PullRequestService {
    private final PullRequestsRepository pullRequestsRepository;

    PullRequestService(PullRequestsRepository pullRequestsRepository) {
        this.pullRequestsRepository = pullRequestsRepository;
    }

    public int modifyFix(String id, CommitAmend amend) {
        Fix fix = pullRequestsRepository.findFix(id);

        fix.modify(amend);

        return 1;
    }

    public int modifyImprovement(String id, CommitAmend amend) {
        Improvement improvement = pullRequestsRepository.findImprovement(id);
        improvement.alterWith(amend);
        return 1;
    }

    public int modifyChangeRequest(String id, CommitAmend amend) {
        ChangeRequest changeRequest = pullRequestsRepository.findChangeRequest(id);

        changeRequest.amend(amend);
        return 1;
    }
}
