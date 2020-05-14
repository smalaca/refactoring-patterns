package com.smalaca.application.service;

import com.smalaca.application.response.Response;
import com.smalaca.domain.*;

public class PullRequestApplicationService {
    private final BranchRepository branchRepository;
    private final PullRequestRepository pullRequestRepository;

    public PullRequestApplicationService(BranchRepository branchRepository, PullRequestRepository pullRequestRepository) {
        this.branchRepository = branchRepository;
        this.pullRequestRepository = pullRequestRepository;
    }

    public Response merge(String branchId, String pullRequestId) {
        Branch branch = branchRepository.find(branchId);
        PullRequest pullRequest = pullRequestRepository.find(pullRequestId);

        if (pullRequest.isPossibleToMergeTo(branch)) {
            branch.merge(pullRequest);
            return Response.success();
        }

        return Response.failure();
    }
}
