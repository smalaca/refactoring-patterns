package com.smalaca.application.service;

import com.smalaca.application.response.Response;
import com.smalaca.domain.*;

public class PullRequestApplicationService {
    private final BranchRepository branchRepository;
    private final PullRequestRepository pullRequestRepository;
    private final PullRequestService pullRequestService;

    public PullRequestApplicationService(BranchRepository branchRepository, PullRequestRepository pullRequestRepository, PullRequestService pullRequestService) {
        this.branchRepository = branchRepository;
        this.pullRequestRepository = pullRequestRepository;
        this.pullRequestService = pullRequestService;
    }

    public Response merge(String branchId, String pullRequestId) {
        try {
            Branch branch = branchRepository.find(branchId);
            PullRequest pullRequest = pullRequestRepository.find(pullRequestId);

            int merge = pullRequestService.merge(branch, pullRequest);

            if (merge == 1) {
                return Response.success();
            } else if (merge == -1) {
                return Response.failure();
            } else {
                return Response.failure();
            }
        } catch (RuntimeException exception) {
            return Response.failure();
        }
    }
}
