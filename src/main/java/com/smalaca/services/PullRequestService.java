package com.smalaca.services;

import com.smalaca.domain.*;

public class PullRequestService {
    private final PullRequestsRepository pullRequestsRepository;

    PullRequestService(PullRequestsRepository pullRequestsRepository) {
        this.pullRequestsRepository = pullRequestsRepository;
    }

    public void modifyFix(String id, CommitAmend amend) {
        Fix fix = (Fix) pullRequestsRepository.findFix(id);

        if (fix.canByModified()) {
            fix.modify(amend);
        }
    }

    public void modifyImprovement(String id, CommitAmend amend) {
        Improvement improvement = (Improvement) pullRequestsRepository.findImprovement(id);

        improvement.alterWith(amend);
    }

    public void modifyChangeRequest(String id, CommitAmend amend) {
        ChangeRequest changeRequest = (ChangeRequest) pullRequestsRepository.findChangeRequest(id);

        if (changeRequest.isClosed()) {
            changeRequest.amend(amend);
        }
    }
}
