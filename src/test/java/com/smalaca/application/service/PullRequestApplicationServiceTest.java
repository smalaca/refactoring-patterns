package com.smalaca.application.service;

import com.smalaca.application.response.Response;
import com.smalaca.domain.Branch;
import com.smalaca.domain.BranchRepository;
import com.smalaca.domain.PullRequest;
import com.smalaca.domain.PullRequestRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PullRequestApplicationServiceTest {
    private static final String BRANCH_ID = UUID.randomUUID().toString();
    private static final String PULL_REQUEST_ID = UUID.randomUUID().toString();
    private static final String BRANCH_NAME = UUID.randomUUID().toString();

    private final BranchRepository branchRepository = mock(BranchRepository.class);
    private final PullRequestRepository pullRequestRepository = mock(PullRequestRepository.class);
    private final PullRequestApplicationService service = new PullRequestApplicationService(branchRepository, pullRequestRepository);

    @Test
    void shouldReturnSuccessWhenMergeSucceed() {
        Branch branch = new Branch(BRANCH_NAME);
        given(branchRepository.find(BRANCH_ID)).willReturn(branch);
        PullRequest pullRequest = mock(PullRequest.class);
        given(pullRequest.isPossibleToMergeTo(branch)).willReturn(true);
        given(pullRequestRepository.find(PULL_REQUEST_ID)).willReturn(pullRequest);

        Response actual = service.merge(BRANCH_ID, PULL_REQUEST_ID);

        assertThat(actual.isSuccess()).isTrue();
    }

    @Test
    void shouldReturnFailureWhenMergeWasNotPossible() {
        Branch branch = new Branch(BRANCH_NAME);
        given(branchRepository.find(BRANCH_ID)).willReturn(branch);
        PullRequest pullRequest = mock(PullRequest.class);
        given(pullRequestRepository.find(PULL_REQUEST_ID)).willReturn(pullRequest);
        given(pullRequest.isPossibleToMergeTo(branch)).willReturn(false);

        Response actual = service.merge(BRANCH_ID, PULL_REQUEST_ID);

        assertThat(actual.isSuccess()).isFalse();
    }
}