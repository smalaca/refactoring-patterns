package com.smalaca.domain;

import java.util.List;

public class Fix extends PullRequest {
    public Fix(Author author, String name, List<Commit> commits) {
        super(author, name, commits);
    }

    public void modify(CommitAmend amend) {
        Commit found = getCommits().stream().filter(commit -> commit.hasSameHashCodeAs(amend)).findFirst().get();
        found.getCodeBaseDelta().change(amend.getCodeBaseDelta());
    }
}
