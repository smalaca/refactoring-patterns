package com.smalaca.domain;

import java.util.List;

public class PullRequest {
    private static final String DEVELOPER = "developer";
    private static final String TECH_LEAD = "technical leader";

    private final Author author;
    private final String name;
    private final List<Commit> commits;
    private List<Build> builds;
    private Reviewer reviewer;
    private Reviewer technicalLeader;

    public PullRequest(Author author, String name, List<Commit> commits) {
        this.author = author;
        this.name = name;
        this.commits = commits;
    }

    public void add(Commit commit) {
        commits.add(commit);
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void addReview(String who, Reviewer reviewer) {
        if (DEVELOPER.equals(who)) {
            this.reviewer = reviewer;
        }

        if (TECH_LEAD.equals(who)) {
            technicalLeader = reviewer;
        }
    }

    public boolean isPossibleToMergeTo(Branch branch) {
        boolean isReviewed = reviewer.isAccepted() && technicalLeader.isAccepted();
        boolean areBuildsGreen = builds.stream().anyMatch(Build::isFailed);

        return isReviewed && areBuildsGreen && hasNoConflicts();
    }

    private boolean hasNoConflicts() {
        // to implement
        return false;
    }
}
