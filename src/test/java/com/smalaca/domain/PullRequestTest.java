package com.smalaca.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PullRequestTest {

    @Test
    void shouldReturnNoCommitsWhenNothingGiven() {
        Author author = mock(Author.class);
        String name = UUID.randomUUID().toString();

        PullRequest pullRequest = new Fix(author, name, new ArrayList<>());

        assertThat(pullRequest.getCommits()).isEmpty();
    }

    @Test
    void shouldReturnCommitsWhenCommitAdded() {
        Author author = mock(Author.class);
        String name = UUID.randomUUID().toString();
        PullRequest pullRequest = new Fix(author, name, new ArrayList<>());
        Commit commit = mock(Commit.class);

        pullRequest.add(commit);

        assertThat(pullRequest.getCommits()).containsExactly(commit);
    }

    @Test
    void shouldReturnCommitsThatWasGivenOnTheBegining() {
        Author author = mock(Author.class);
        String name = UUID.randomUUID().toString();
        Commit commit1 = mock(Commit.class);
        Commit commit2 = mock(Commit.class);
        List<Commit> commits = new ArrayList<>(asList(commit1, commit2));

        PullRequest pullRequest = new Fix(author, name, commits);

        assertThat(pullRequest.getCommits()).containsExactly(commit1, commit2);
    }

    @Test
    void shouldReturnAddCommitToExisting() {
        Author author = mock(Author.class);
        String name = UUID.randomUUID().toString();
        Commit commit1 = mock(Commit.class);
        Commit commit2 = mock(Commit.class);
        PullRequest pullRequest = new Fix(author, name, new ArrayList<>(asList(commit1, commit2)));
        Commit commit3 = mock(Commit.class);
        Commit commit4 = mock(Commit.class);

        pullRequest.add(commit3);
        pullRequest.add(commit4);

        assertThat(pullRequest.getCommits()).containsExactly(commit1, commit2, commit3, commit4);
    }
}