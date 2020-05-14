package com.smalaca.application.service;

import com.smalaca.application.response.Response;
import com.smalaca.domain.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class PullRequestApplicationServiceTest {
    private static final String BRANCH_ID = UUID.randomUUID().toString();
    private static final String PULL_REQUEST_ID = UUID.randomUUID().toString();

    private final BranchRepository branchRepository = mock(BranchRepository.class);
    private final PullRequestRepository pullRequestRepository = mock(PullRequestRepository.class);
    private final PullRequestApplicationService service = new PullRequestApplicationService(branchRepository, pullRequestRepository, new PullRequestService());

    @Test
    void shouldReturnSuccessWhenMergeSucceed() {
        Branch branch = mock(Branch.class);
        given(branchRepository.find(BRANCH_ID)).willReturn(branch);
        PullRequest pullRequest = mock(PullRequest.class);
        given(pullRequestRepository.find(PULL_REQUEST_ID)).willReturn(pullRequest);

        Response actual = service.merge(BRANCH_ID, PULL_REQUEST_ID);

        assertThat(actual.isSuccess()).isTrue();
    }

    @Test
    void shouldReturnFailureWhenMergeWasNotPossible() {
        PullRequest pullRequest = mock(PullRequest.class);
        given(pullRequestRepository.find(PULL_REQUEST_ID)).willReturn(pullRequest);
        Branch branch = mock(Branch.class);
        given(branchRepository.find(BRANCH_ID)).willReturn(branch);
        doThrow(new MergeException(branch, pullRequest)).when(branch).merge(pullRequest);

        Response actual = service.merge(BRANCH_ID, PULL_REQUEST_ID);

        assertThat(actual.isSuccess()).isFalse();
    }
}