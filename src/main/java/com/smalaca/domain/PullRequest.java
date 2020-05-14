package com.smalaca.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

abstract public class PullRequest {
    private static final String DEVELOPER = "developer";
    private static final String TECH_LEAD = "technical leader";

    private final Author author;
    private final String name;
    private final List<Commit> commits;
    private final LocalDate creationDate;
    private Date mergeDate;
    private List<Build> builds;
    private Reviewer reviewer;
    private Reviewer technicalLeader;

    public PullRequest(Author author, String name, List<Commit> commits) {
        this.author = author;
        this.name = name;
        this.commits = commits;
        creationDate = LocalDate.now();
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

    public Author getAuthor() {
        return author;
    }

    public List<Reviewer> getReviewers() {
        return asList(reviewer, technicalLeader);
    }

    public boolean isPossibleToMergeTo(Branch branch) {
        return isReviewed() && areBuildsGreen() && hasNoConflicts();
    }

    private boolean isReviewed() {
        return reviewer.isAccepted() && technicalLeader.isAccepted();
    }

    private boolean areBuildsGreen() {
        return builds.stream().anyMatch(Build::isFailed);
    }

    private boolean hasNoConflicts() {
        // to implement
        return false;
    }

    public void setMergeDate(Date mergeDate) {
        this.mergeDate = mergeDate;
    }

    public Date getMergeDate() {
        return mergeDate;
    }
}
